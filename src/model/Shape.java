package model;


import controller.ColorAdapter;
import controller.Point;
import modelInterfaces.IShape;

public class Shape implements IShape{
	private ColorAdapter _primaryColor;
	private ColorAdapter _secondaryColor;
	private Point _startPoint;
	private Point _endPoint;
	
	public Shape(ColorAdapter primaryColor, ColorAdapter secondaryColor, Point startPoint, Point endPoint){
		this._primaryColor = primaryColor;
		this._secondaryColor = secondaryColor;
		this._startPoint = startPoint;
		this._endPoint = endPoint;
	}
	
	
	public int getStartX(){
		return _startPoint.getX();
		}
	public int getStartY(){
		return _startPoint.getY();
		}
	public int getEndX(){
		return _endPoint.getX();
		}
	public int getEndY(){
		return _endPoint.getY();
		}
	
	public int getWidth(){
		return _endPoint.getX() - _startPoint.getX();
	}
	public int getHeight(){
		return _endPoint.getY() - _startPoint.getY();
	}
	
	
	
	public ColorAdapter getPrimaryColor(){
		return _primaryColor;
	}
	
	public ColorAdapter getSecondaryColor(){
		return _secondaryColor;
	}
	
	public Point getStartPoint(){
		return _startPoint;
	}
	public Point getEndPoint(){
		return _endPoint;
	}


	public void setEndPoint(Point endPoint) {
		this._endPoint = endPoint;
	}


	public void setStartPoint(Point startPoint) {
		this._startPoint = startPoint;		
	}
}

