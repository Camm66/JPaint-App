package controller;

import java.util.List;

import ControllerInterface.CommandHistory;
import ControllerInterface.ICommand;
import ControllerInterface.RecordDeleteCommand;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class _DeleteCommand implements ICommand{
	private final IShapeList _shapeList;
	
	
	public _DeleteCommand(IShapeList shapeList){
		_shapeList = shapeList;
	}
	
	@Override
	public void run() {
		if(!_shapeList.getObservers().isEmpty()){
			List<IDisplayableShape> foundShapes = _shapeList.getCurrentlySelectedShape();
			RecordDeleteCommand command = new RecordDeleteCommand(foundShapes, _shapeList);
			command.delete();
			CommandHistory.add(command);
		}
	}
}