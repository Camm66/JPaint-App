package view;

import controller.ShapeType;
import model.Shape;
import modelInterfaces.IViewShape;
import modelInterfaces.IViewShapeFactory;
import view.GuiUiModule.GuiEllipse;
import view.GuiUiModule.GuiRectangle;
import view.GuiUiModule.GuiTriangle;
import view.GuiUiModule.PaintCanvas;

public class GuiViewShapeFactory implements IViewShapeFactory{
	private final PaintCanvas canvas;
	
	public GuiViewShapeFactory(PaintCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public IViewShape createViewShape(ShapeType currentShape, Shape shape) throws Exception {		
		switch(currentShape){
			case ELLIPSE:
				return new GuiEllipse(shape, canvas);
			case RECTANGLE:
				return new GuiRectangle(shape, canvas);
			case TRIANGLE:
				return new GuiTriangle(shape, canvas);
			default:
				throw new Exception("Incorrect ViewShape Identified");
		}
	}
}
