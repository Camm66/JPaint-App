package model;

import controller.*;
import modelInterfaces.*;

public class ShapeFactory implements IShapeFactory {
	private final ApplicationSettings settings;
	private final IShapeList shapeList;
	private final IViewShapeFactory viewShapeFactory;
	private final IDisplayableShapeFactory displayableShapeFactory;
	
	public ShapeFactory(ApplicationSettings settings, IShapeList shapeList, IViewShapeFactory viewShapeFactory, IDisplayableShapeFactory displayableShapeFactory){
		this.settings = settings;
		this.shapeList = shapeList;
		this.viewShapeFactory = viewShapeFactory;
		this.displayableShapeFactory = displayableShapeFactory;
	}
	
	@Override
	public void create(Point startingPoint, Point endingPoint) throws Exception {
		Point adjustedStartingPoint = getAdjustedStartingPoint(startingPoint, endingPoint);
		Point adjustedEndingPoint = getAdjustedEndingPoint(startingPoint, endingPoint);
		IViewShape viewShape = getIViewShape(adjustedStartingPoint, adjustedEndingPoint);
		IDisplayableShape displayableShape = getIDisplayableShape(viewShape);
		shapeList.addToList(displayableShape);
		
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
	
	private IViewShape getIViewShape(Point startingPoint, Point endingPoint) throws Exception{
		ShapeType currentShape = settings.getDrawShapeSettings().getCurrentShape();
		Shape shape = createShape(startingPoint, endingPoint);
		return viewShapeFactory.createViewShape(currentShape, shape);
	}
	
	private IDisplayableShape getIDisplayableShape(IViewShape viewShape) throws Exception{
		ShadingType currentShading = settings.getShadingTypeShapeSettings().getCurrentShadingType();
		return displayableShapeFactory.createDisplayShape(currentShading, viewShape);
	}
	
	private Shape createShape(Point startingPoint, Point endingPoint){
		ColorAdapter primaryColor = settings.getPrimaryColorShapeSettings().getCurrentColor();
		ColorAdapter secondaryColor = settings.getSecondaryColorShapeSettings().getCurrentColor();
		return new Shape(primaryColor, secondaryColor, startingPoint, endingPoint);
	}
	
}
