package view;

import controller.Point;
import modelInterfaces.IDisplayableShape;

public class PointFinder {
	
	private Point selectionPoint;
	private Point selectionAreaCenter;
	
	public Point getNewStartPoint(IDisplayableShape shape, Point endPoint){
		int diffX = endPoint.getX() - shape.getShape().getShape().getEndPoint().getX();
		int diffY = endPoint.getY() - shape.getShape().getShape().getEndPoint().getY();
		int newX = shape.getShape().getShape().getStartPoint().getX() + diffX;
		int newY = shape.getShape().getShape().getStartPoint().getY() + diffY;
		Point newStartPoint = new Point(newX, newY);
		return newStartPoint;
	}
	public Point getNewEndPoint(IDisplayableShape shape, Point selectionPoint) {
		int diffX = this.getSelectionPoint().getX() - selectionAreaCenter.getX();
		int diffY = this.getSelectionPoint().getY() - selectionAreaCenter.getY(); 
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
	public Point getSelectionPoint() {
		return selectionPoint;
	}
	public void setSelectionPoint(Point selectionPoint) {
		this.selectionPoint = selectionPoint;
	}
}
