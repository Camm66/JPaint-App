package ControllerInterface;

import java.util.List;

import controller.Point;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class MultipleShapeCopier implements ICopyStrategy{
	public List<IDisplayableShape> pasteCopiedShape(List<IDisplayableShape> copiedShapes, List<IDisplayableShape> pastedShapes, Point endPoint, IShapeList shapeList){
		for(IDisplayableShape copiedShape : copiedShapes){
			Point newEndPoint = shapeList.getNewEndPoint(copiedShape, endPoint);
			Point newStartPoint = shapeList.getStartNewPoint(copiedShape, newEndPoint);
			IDisplayableShape pastedShape = copiedShape;
			try {
				pastedShape = shapeList.getShapeCloneFactory().create(copiedShape, newStartPoint, newEndPoint);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				shapeList.addToList(pastedShape);
				pastedShapes.add(pastedShape);
			}	
		}
		return pastedShapes;
	}
}	

