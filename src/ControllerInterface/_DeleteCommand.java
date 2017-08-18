package ControllerInterface;

import java.util.List;

import controller.ShapeList;
import modelInterfaces.IDisplayableShape;
import viewInterfaces.UIModule;

public class _DeleteCommand implements ICommand{
	private final ShapeList _shapeList;
	
	
	public _DeleteCommand(ShapeList shapeList){
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
//clear
