package controller;

public class Shape {
	private ColorAdapter primaryColor;
	private ColorAdapter secondaryColor;
	//private ShapeType shape;
	private Point startPoint;
	private Point endPoint;
	
	public Shape(ColorAdapter primaryColor, ColorAdapter secondaryColor, Point startPoint, Point endPoint){
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	
	public int getStartX(){
		return startPoint.getX();
		}
	public int getStartY(){
		return startPoint.getY();
		}
	public int getEndX(){
		return endPoint.getX();
		}
	public int getEndY(){
		return endPoint.getY();
		}
	
	public int getWidth(){
		return endPoint.getX() - startPoint.getX();
	}
	public int getHeight(){
		return endPoint.getY() - startPoint.getY();
	}
	
	
	
	public ColorAdapter getPrimaryColor(){
		return primaryColor;
	}
	
	public ColorAdapter getSecondaryColor(){
		return secondaryColor;
	}
}

//created 7/26

