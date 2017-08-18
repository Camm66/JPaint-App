package ControllerInterface;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.Point;
import controller.ShapeList;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IStartAndEndPointCommand;
import viewInterfaces.UIModule;

public class _PasteCommand implements ICommand{
	private final UIModule _uiModule;
	private final ShapeList _shapeList;

	
	public _PasteCommand(UIModule uiModule, ShapeList shapeList){
		this._uiModule = uiModule;
		this._shapeList = shapeList;
	}

	public void run(){
		if(_shapeList.getCurrentlyCopiedShape() != null){
			
			List<IDisplayableShape> copiedShapes = _shapeList.getCurrentlyCopiedShape();
			List<IDisplayableShape> pastedShapes = new ArrayList<IDisplayableShape>();
			
			Point endPoint = _shapeList.getSelectionPoint();
			if(endPoint == null)
				return;
			if(copiedShapes.size() > 1){
				for(IDisplayableShape copiedShape : copiedShapes){
					Point newEndPoint = _shapeList.getNewEndPoint(copiedShape, endPoint);
					Point newStartPoint = _shapeList.getStartNewPoint(copiedShape, newEndPoint);
					IDisplayableShape pastedShape = copiedShape;
					try {
						pastedShape = _shapeList.getShapeCloneFactory().createClone(copiedShape, newStartPoint, newEndPoint);
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						_shapeList.addToList(pastedShape);
						pastedShapes.add(pastedShape);
					}	
				}
			}
			else{
				for(IDisplayableShape copiedShape : copiedShapes){
					Point newStartPoint = _shapeList.getStartNewPoint(copiedShape, endPoint);
					IDisplayableShape pastedShape = copiedShape;
					try {
						pastedShape = _shapeList.getShapeCloneFactory().createClone(copiedShape, newStartPoint, endPoint);
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						_shapeList.addToList(pastedShape);
						pastedShapes.add(pastedShape);
					
					}	
				}
			}
			CommandHistory.add(new RecordPasteCommand(pastedShapes, _shapeList));
		}
	}
}

