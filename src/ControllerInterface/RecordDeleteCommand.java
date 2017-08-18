package ControllerInterface;

import java.util.List;

import controller.ShapeList;
import modelInterfaces.IDisplayableShape;

public class RecordDeleteCommand implements IUndoable{
	private List<IDisplayableShape> payLoad;
	private final ShapeList shapeList;
	
	public RecordDeleteCommand(List<IDisplayableShape> foundShapes, ShapeList shapeList) {
		this.payLoad = foundShapes;
		this.shapeList = shapeList;
	}

	@Override
	public void undo() {
		for(IDisplayableShape shape: payLoad)
			shapeList.getObservers().add(shape);
		shapeList.updateCanvas();
	}

	@Override
	public void redo() {
		delete();
	}

	@Override
	public void delete() {
		for(IDisplayableShape shape: payLoad)
			shapeList.getObservers().remove(shape);
		shapeList.updateCanvas();
	}
}
//clear