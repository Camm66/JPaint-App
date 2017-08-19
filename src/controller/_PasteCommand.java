package controller;

import java.util.ArrayList;
import java.util.List;

import ControllerInterface.CommandHistory;
import ControllerInterface.ICommand;
import ControllerInterface.RecordPasteCommand;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class _PasteCommand implements ICommand{
	private final IShapeList _shapeList;
	
	public _PasteCommand(IShapeList shapeList){
		this._shapeList = shapeList;
	}
	
	public void run(){
		List<IDisplayableShape> pastedShapes = new ArrayList<IDisplayableShape>();
		ShapeCopier shapeCopier = CopyStrategyFactory.createCopier(_shapeList);
		if(_shapeList.getCurrentlyCopiedShape() != null){
			pastedShapes = shapeCopier.pasteShape();
			CommandHistory.add(new RecordPasteCommand(pastedShapes, _shapeList));
		}
	}
}
