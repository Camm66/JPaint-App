package modelInterfaces;

import controller.Shape;
import controller.ShapeType;

public interface IViewShapeFactory {

	IViewShape createViewShape(ShapeType currentShape, Shape shape);

}