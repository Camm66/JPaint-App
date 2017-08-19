package ControllerInterface;

import java.util.ArrayList;
import java.util.List;

import controller.Point;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

 public class ShapeCopier {
		private final IShapeList shapeList;
		private List<IDisplayableShape> copiedShapes;
		private List<IDisplayableShape> pastedShapes = new ArrayList<IDisplayableShape>();
		private Point selectionPoint;
		private ICopyStrategy method;
		
		public ShapeCopier(IShapeList shapeList, ICopyStrategy method){
			this.shapeList = shapeList;
			this.method = method;
			copiedShapes = shapeList.getCurrentlyCopiedShape();
			selectionPoint = shapeList.getSelectionPoint();
		}
		
		public List<IDisplayableShape> pasteShape(){
			if(selectionPoint == null)
				return copiedShapes;
			else
				return method.pasteCopiedShape(copiedShapes, pastedShapes, selectionPoint, shapeList);		
		}
}
