package controller;


import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.Shape;
import model.ShapeCloneFactory;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public class ShapeList implements IShapeList {
	private List<IDisplayableShape> observers = new ArrayList<IDisplayableShape>();
	private PaintCanvas canvas;
	private ShapeCloneFactory shapeCloneFactory;
	private List<IDisplayableShape> selectedShapes;
	private List<IDisplayableShape> copiedShapes;
	private Point selectionPoint;
	private Point selectionAreaCenter;
	
	@Override
	public void addToList(IDisplayableShape displayableShape) {
		observers.add(displayableShape);
		updateCanvas();
		}
	
	final Runnable notifyObservers = new Runnable(){
			public void run(){
				canvas.update(observers);
		}
	};
	
	public void undoRecentObserver(Object payload){
		observers.remove(payload);
		updateCanvas();
	}
	
	public void redoRecentObserver(Object payLoad){
		observers.add((IDisplayableShape) payLoad);
		updateCanvas();
	}
	
	public void updateCanvas(){
		canvas.repaint();
		SwingUtilities.invokeLater(notifyObservers);
	}

	public void registerObserver(PaintCanvas canvas) {
		this.canvas = canvas;
	}
	
	///////////////////////////////
	public ShapeCloneFactory getShapeCloneFactory() {
		return shapeCloneFactory;
	}

	public void setShapeCloneFactory(ShapeCloneFactory shapeCloneFactory) {
		this.shapeCloneFactory = shapeCloneFactory;
	}	
	
	public List<IDisplayableShape> getObservers(){
		return observers;
	}
	
	public List<IDisplayableShape> getCurrentlySelectedShape(){
		return selectedShapes;
	}
	
	public void setCurrentlySelectedShape(List<IDisplayableShape> selectedShapes){
		this.selectedShapes = selectedShapes;
	}
	
	public List<IDisplayableShape> getCurrentlyCopiedShape(){
		return copiedShapes;
	}
	
	
	public void setCurrentlyCopiedShape(List<IDisplayableShape> copiedShapes){
		this.copiedShapes = copiedShapes;
	}
	
	public Point getSelectionPoint(){
		return selectionPoint;
	}
	
	public void setSelectionPoint(Point selectedPoint){
		System.out.println(selectedPoint);
		this.selectionPoint = selectedPoint;
	}

	
////////////////////////////////////////////////////////////////////////////////////////
	public Point moveSelectedShape(IDisplayableShape shape, Point endPoint){
		observers.remove(shape);
		return getStartNewPoint(shape, endPoint);
	}
	
	public List<IDisplayableShape> findSelectedShape(Point startingPoint, Point endingPoint){
		List<IDisplayableShape> foundShapes = new ArrayList<IDisplayableShape>();
		Shape inputShape = new Shape(null, null, startingPoint, endingPoint);
		
		if((startingPoint.getX() == endingPoint.getX()) && (startingPoint.getY() == endingPoint.getY())){
			for(IDisplayableShape observer : observers){
				Shape observerShape = observer.getShape().getShape();
				if(collisionDetected(observerShape, inputShape)){
					foundShapes.add(observer);
					return foundShapes;
				}
			}
		}
		else{
			for(IDisplayableShape observer : observers){
				Shape observerShape = observer.getShape().getShape();
				if(collisionDetected(observerShape, inputShape))
					foundShapes.add(observer);
			}
		}
		return foundShapes;
	}
	
	private boolean collisionDetected(Shape observerShape, Shape inputShape){
		if(inputShape.getStartX() < observerShape.getStartX() + observerShape.getWidth()
		&& inputShape.getStartX() + inputShape.getWidth() > observerShape.getStartX() 
		&& inputShape.getStartY() < observerShape.getStartY() + observerShape.getHeight() 
		&& inputShape.getStartY() + inputShape.getHeight() > observerShape.getStartY())
			return true;
		else
			return false;
	}
	public Point getStartNewPoint(IDisplayableShape shape, Point endPoint){
		int diffX = endPoint.getX() - shape.getShape().getShape().getEndPoint().getX();
		int diffY = endPoint.getY() - shape.getShape().getShape().getEndPoint().getY();
		int newX = shape.getShape().getShape().getStartPoint().getX() + diffX;
		int newY = shape.getShape().getShape().getStartPoint().getY() + diffY;
		Point newStartPoint = new Point(newX, newY);
		return newStartPoint;
	}
	public Point getNewEndPoint(IDisplayableShape shape, Point selectionPoint) {
		int diffX = this.selectionPoint.getX() - selectionAreaCenter.getX();
		int diffY = this.selectionPoint.getY() - selectionAreaCenter.getY(); 
		int newX = shape.getShape().getShape().getEndPoint().getX() + diffX;
		int newY = shape.getShape().getShape().getEndPoint().getY() + diffY;
		return new Point(newX, newY);
	}
	

	public void setSelectionArea(Point startingPoint, Point endingPoint) {
		int maxX = Math.max(startingPoint.getX(), endingPoint.getX());
		int maxY = Math.max(startingPoint.getY(), endingPoint.getY());
		int minX = Math.min(startingPoint.getX(), endingPoint.getX());
		int minY = Math.min(startingPoint.getY(), endingPoint.getY());
		int centerX = (maxX - minX)/2;
		int centerY = (maxY - minY)/2;
		selectionAreaCenter = new Point(maxX - centerX, maxY - centerY);
	}
	

}	
	

