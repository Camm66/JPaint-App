package view.GuiUiModule;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Polygon;

import controller.ColorAdapter;
import controller.Shape;
import modelInterfaces.IViewShape;

public class GuiTriangle implements IViewShape {
    private Shape shape;
    private Polygon triangle;
    private PaintCanvas canvas;

    public GuiTriangle(Shape shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
        this.triangle = (new TriangleShapeCreator(shape)).getTriangle();
    }

    @Override
    public void displayOutline(ColorAdapter color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(color.getColor());        
        graphics.draw(triangle);
    }

    @Override
    public void displayFilled(ColorAdapter color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(color.getColor());
        graphics.fill(triangle);
    }

    @Override
    public ColorAdapter getPrimaryColor() {
        return shape.getPrimaryColor();
    }

    @Override
    public ColorAdapter getSecondaryColor() {
        return shape.getSecondaryColor();
    }
}
