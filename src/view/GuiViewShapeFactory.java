package view;

import controller.Shape;
import controller.ShapeType;
import modelInterfaces.IViewShape;
import modelInterfaces.IViewShapeFactory;
import view.GuiUiModule.PaintCanvas;

public class GuiViewShapeFactory implements IViewShapeFactory{
	private final PaintCanvas canvas;
	
	public GuiViewShapeFactory(PaintCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public IViewShape createViewShape(ShapeType currentShape, Shape shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
