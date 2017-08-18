package view.GuiUiModule;

import controller.ColorAdapter;
import controller.Point;
import controller.ShapeType;
import model.Shape;
import modelInterfaces.IViewShape;

import java.awt.*;
import java.io.Serializable;

public class GuiEllipse implements IViewShape, Serializable {
    private Shape shape;
    private PaintCanvas canvas;
    private final ShapeType shapeType = ShapeType.ELLIPSE;

    public GuiEllipse(Shape shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void displayOutline(ColorAdapter color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(color.getColor());
        graphics.drawOval(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public void displayFilled(ColorAdapter color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(color.getColor());
        graphics.fillOval(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public ColorAdapter getPrimaryColor() {
        return shape.getPrimaryColor();
    }

    @Override
    public ColorAdapter getSecondaryColor() {
        return shape.getSecondaryColor();
    }
    
    public Point getStartPoint(){
    	return shape.getStartPoint();
    }
    
    public ShapeType getShapeType(){
    	return shapeType;
    }

	@Override
	public Shape getShape() {
		return this.shape;
	}
}
