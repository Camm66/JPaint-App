package view.GuiUiModule;

import java.awt.Polygon;

import model.Shape;

public class TriangleShapeCreator extends Polygon {
	private int p1X;
    private int p1Y;
    private int p2X;
    private int p2Y;
    private double angle;
    private Polygon myTriangle;
    
    public TriangleShapeCreator(Shape shape){
    	this.p1X = shape.getStartX();
    	this.p1Y = shape.getStartY();
    	this.p2X = shape.getEndX();
    	this.p2Y = shape.getEndY();
    	this.angle = 0;
    	createTriangle();
    }
    
    private void createTriangle(){
    	if((p2X < p1X))
    		angle = (Math.atan2((p2X - p1X), (p1Y - p2Y)) * 180 / Math.PI);
    	else if((p2X > p1X))//above 180 degrees to 360/0
    		angle = 360 - (Math.atan2((p1X - p2X), (p1Y - p2Y)) * 180 / Math.PI);
 
    	int p3X = (int) ((p1X - p2X) * Math.cos(angle) - (p1Y - p2Y) * Math.sin(angle) + p2X);
    	int p3Y = (int) ((p1X - p2X) * Math.sin(angle) - (p1Y - p2Y) * Math.cos(angle) + p2Y);
     
    	this.myTriangle = new Polygon(
     		new int[]{p1X, p2X ,p3X},
     		new int[]{p1Y, p2Y, p3Y}, 3);
    }
    
    public Polygon getTriangle(){
    	return myTriangle;
    }
}
