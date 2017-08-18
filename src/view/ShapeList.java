package view;


import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import controller.Point;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public class ShapeList implements IShapeList {
	private List<IDisplayableShape> observers = new ArrayList<IDisplayableShape>();
	private PaintCanvas canvas;
	private ShapeCloneFactory shapeCloneFactory;
	private List<IDisplayableShape> selectedShapes;
	private List<IDisplayableShape> copiedShapes;
	private ShapeFinder shapeFinder = new ShapeFinder();
	private PointFinder pointFinder = new PointFinder();
	
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
	
	public List<IDisplayableShape> getObservers(){
		return observers;
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
	
	
///////////////////////////////////////////
	
	
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

	
////////////////////////////////////////////////////////////////////////////////////////
	public Point moveSelectedShape(IDisplayableShape shape, Point endPoint){
		observers.remove(shape);
		return getStartNewPoint(shape, endPoint);
	}
	
	public List<IDisplayableShape> findSelectedShape(Point startingPoint, Point endingPoint){
		return shapeFinder.findSelectedShape(startingPoint, endingPoint, observers);
	}
	
	public Point getStartNewPoint(IDisplayableShape shape, Point endPoint){
		return pointFinder.getNewStartPoint(shape, endPoint);
	}
	
	public Point getNewEndPoint(IDisplayableShape shape, Point selectionPoint) {
		return pointFinder.getNewEndPoint(shape, selectionPoint);
	}
	
	public Point getSelectionPoint(){
		return pointFinder.getSelectionPoint();
	}
	
	public void setSelectionPoint(Point selectedPoint){
		pointFinder.setSelectionPoint(selectedPoint);
	}
	

	public void setSelectionArea(Point startingPoint, Point endingPoint) {
		pointFinder.setSelectionArea(startingPoint, endingPoint);
	}
}	
	

