package ControllerInterface;

import java.util.List;

import controller.Point;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public interface ICopyStrategy {
	List<IDisplayableShape> pasteCopiedShape(List<IDisplayableShape> copiedShapes, List<IDisplayableShape> pastedShapes, Point endPoint, IShapeList shapeList);
}
