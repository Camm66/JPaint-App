package ControllerInterface;

import controller.ShapeList;
import viewInterfaces.UIModule;

public class _CopyCommand implements ICommand{
	private final UIModule _uiModule;
	private final ShapeList _shapeList;
	
	public _CopyCommand(UIModule uiModule, ShapeList shapeList){
		this._uiModule = uiModule;
		this._shapeList = shapeList;
	}

	@Override
	public void run() {
		if(_shapeList.getCurrentlySelectedShape() != null){
			_shapeList.setCurrentlyCopiedShape(_shapeList.getCurrentlySelectedShape());
			_shapeList.setSelectionPoint(null);
		}
	}
}
//clear;