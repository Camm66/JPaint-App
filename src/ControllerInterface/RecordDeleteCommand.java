package ControllerInterface;

import java.util.List;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class RecordDeleteCommand implements IUndoable{
	private List<IDisplayableShape> payLoad;
	private final IShapeList shapeList;
	
	public RecordDeleteCommand(List<IDisplayableShape> foundShapes, IShapeList shapeList) {
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
