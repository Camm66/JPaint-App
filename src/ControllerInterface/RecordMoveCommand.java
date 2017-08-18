package ControllerInterface;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class RecordMoveCommand implements IUndoable{
	private IDisplayableShape formerPayload;
	private IDisplayableShape payLoad;
	private final IShapeList shapeList;
	
	
	public RecordMoveCommand(IDisplayableShape formerPayload, IDisplayableShape payLoad, IShapeList shapeList){
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