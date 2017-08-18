package ControllerInterface;

import java.util.List;

import controller.ShapeList;
import modelInterfaces.IDisplayableShape;

public class RecordPasteCommand implements IUndoable{
	private List<IDisplayableShape> payLoad;
	private ShapeList shapeList;
	
	public RecordPasteCommand(List<IDisplayableShape> payLoad, ShapeList shapeList) {
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
//clear
}
