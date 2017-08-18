package ControllerInterface;

import java.util.List;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class RecordPasteCommand implements IUndoable{
	private List<IDisplayableShape> payLoad;
	private IShapeList shapeList;
	
	public RecordPasteCommand(List<IDisplayableShape> payLoad, IShapeList shapeList) {
		this.payLoad = payLoad;
		this.shapeList = shapeList;
	}

	@Override
	public void undo() {
		for(IDisplayableShape shape: payLoad)
			shapeList.getObservers().remove(shape);
		shapeList.updateCanvas();
	}

	@Override
	public void redo() {
		for(IDisplayableShape shape: payLoad)
			shapeList.getObservers().add(shape);
		shapeList.updateCanvas();
	}

	@Override
	public void delete() {}
}
