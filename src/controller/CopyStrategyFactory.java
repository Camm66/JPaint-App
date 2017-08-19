package controller;

import modelInterfaces.IShapeList;

public class CopyStrategyFactory {
	public static ShapeCopier createCopier(IShapeList shapeList){
		if(shapeList.getCurrentlyCopiedShape().size() > 1)
			return new ShapeCopier(shapeList, new MultipleShapeCopier());
		else
			return new ShapeCopier(shapeList, new SingleShapeCopier());		
	}
}
