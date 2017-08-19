package controller;

import ControllerInterface.ICommand;
import modelInterfaces.IShapeList;

public class _CopyCommand implements ICommand{
	private final IShapeList _shapeList;
	
	public _CopyCommand(IShapeList shapeList){
		this._shapeList = shapeList;
	}

	@Override
	public void run() {
		if(_shapeList.getCurrentlySelectedShape() != null){
			_shapeList.setCurrentlyCopiedShape(_shapeList.getCurrentlySelectedShape());
		}
	}
}