package view;

import controller.ColorAdapter;
import controller.Point;
import controller.ShadingType;
import controller.ShapeType;
import model.Shape;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IDisplayableShapeFactory;
import modelInterfaces.IViewShape;
import modelInterfaces.IViewShapeFactory;

public class ShapeCloneFactory{
	private final IViewShapeFactory viewShapeFactory;
	private final IDisplayableShapeFactory displayableShapeFactory;
	
	
	public ShapeCloneFactory(IViewShapeFactory viewShapeFactory, IDisplayableShapeFactory displayableShapeFactory){
		this.viewShapeFactory = viewShapeFactory;
		this.displayableShapeFactory = displayableShapeFactory;
	}
	
	public IDisplayableShape create(IDisplayableShape shapeToCopy, Point startingPoint, Point endingPoint)throws Exception{
		Point adjustedStartingPoint = getAdjustedStartingPoint(startingPoint, endingPoint);
		Point adjustedEndingPoint = getAdjustedEndingPoint(startingPoint, endingPoint);
		IViewShape viewShape = getIViewShape(shapeToCopy, adjustedStartingPoint, adjustedEndingPoint);
		IDisplayableShape shapeCopy = getIDisplayableShape(shapeToCopy, viewShape);
		return shapeCopy;
	}
	
	private Point getAdjustedStartingPoint(Point startingPoint, Point endingPoint) {
		int startingX = Math.min(startingPoint.getX(), endingPoint.getX());
		int startingY = Math.min(startingPoint.getY(), endingPoint.getY());
		
		return new Point(startingX, startingY);
	}
	
	private Point getAdjustedEndingPoint(Point startingPoint, Point endingPoint) {
		int endingX = Math.max(startingPoint.getX(), endingPoint.getX());
		int endingY = Math.max(startingPoint.getY(), endingPoint.getY());
		
		return new Point(endingX, endingY);
	}
	
	private IViewShape getIViewShape(IDisplayableShape shapeToCopy, Point startingPoint, Point endingPoint) throws Exception{
		ShapeType currentShape = shapeToCopy.getShape().getShapeType();
		Shape shape = createShape(shapeToCopy, startingPoint, endingPoint);
		return viewShapeFactory.createViewShape(currentShape, shape);
	}
	
	private Shape createShape(IDisplayableShape shapeToCopy, Point startingPoint, Point endingPoint){
		ColorAdapter primaryColor = shapeToCopy.getShape().getShape().getPrimaryColor();
		ColorAdapter secondaryColor = shapeToCopy.getShape().getShape().getSecondaryColor();
		return new Shape(primaryColor, secondaryColor, startingPoint, endingPoint);
	}	
	
	private IDisplayableShape getIDisplayableShape(IDisplayableShape shapeToCopy, IViewShape viewShape) throws Exception{
		ShadingType currentShading = shapeToCopy.getShadingType();
		return displayableShapeFactory.createDisplayShape(currentShading, viewShape);
	}
}
