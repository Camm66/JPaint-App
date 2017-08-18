package ControllerInterface;

import controller.ShapeList;

public class RecordSelectCommand implements IUndoable{
	private Object payLoad;
	private final ShapeList shapeList;
	
	
	public RecordSelectCommand(Object Payload, ShapeList shapeList){
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
//clear
