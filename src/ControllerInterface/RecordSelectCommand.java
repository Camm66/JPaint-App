package ControllerInterface;

import modelInterfaces.IShapeList;

public class RecordSelectCommand implements IUndoable{
	private Object payLoad;
	private final IShapeList shapeList;
	
	
	public RecordSelectCommand(Object Payload, IShapeList shapeList){
		this.payLoad = Payload;
		this.shapeList = shapeList;
	}
	
	public Object getPayLoad(){
		return payLoad;
	}

	@Override
	public void undo(){	}

	@Override
	public void redo() {}

	@Override
	public void delete() {
		shapeList.getObservers().remove(payLoad);
		shapeList.updateCanvas();
	}
}