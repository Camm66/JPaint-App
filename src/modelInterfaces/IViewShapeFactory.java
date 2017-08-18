package modelInterfaces;

import controller.ShapeType;
import model.Shape;

public interface IViewShapeFactory {

	IViewShape createViewShape(ShapeType currentShape, Shape shape) throws Exception;

}
