package controller;

import java.util.List;

import ControllerInterface.ICopyStrategy;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class SingleShapeCopier implements ICopyStrategy{
	public List<IDisplayableShape> pasteCopiedShape(List<IDisplayableShape> copiedShapes, List<IDisplayableShape> pastedShapes, Point endPoint, IShapeList shapeList){
		for(IDisplayableShape copiedShape : copiedShapes){
			Point newStartPoint = shapeList.getStartNewPoint(copiedShape, endPoint);
			IDisplayableShape pastedShape = copiedShape;
			try {
				pastedShape = shapeList.getShapeCloneFactory().create(copiedShape, newStartPoint, endPoint);
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

