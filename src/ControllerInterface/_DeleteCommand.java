package ControllerInterface;

import java.util.List;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.ShapeList;

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