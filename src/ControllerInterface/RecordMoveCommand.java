package ControllerInterface;

import java.util.List;

import controller.ShapeList;
import modelInterfaces.IDisplayableShape;

public class RecordMoveCommand implements IUndoable{
	private IDisplayableShape formerPayload;
	private IDisplayableShape payLoad;
	private final ShapeList shapeList;
	
	
	public RecordMoveCommand(IDisplayableShape formerPayload, IDisplayableShape payLoad, ShapeList shapeList){
		this.formerPayload = formerPayload;
		this.payLoad = payLoad;
		this.shapeList = shapeList;
	}
	
	@Override
	public void undo(){
		shapeList.getObservers().remove(payLoad);
		shapeList.getObservers().add(formerPayload);
		shapeList.updateCanvas();
	}

	@Override
	public void redo() {
		shapeList.getObservers().remove(formerPayload);
		shapeList.getObservers().add(payLoad);
		shapeList.updateCanvas();
	}

	@Override
	public void delete() {}
}
//clear