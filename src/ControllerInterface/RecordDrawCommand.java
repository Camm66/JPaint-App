package ControllerInterface;

import controller.ShapeList;
import modelInterfaces.IDisplayableShape;

public class RecordDrawCommand implements IUndoable{
	private Object payLoad;
	private final ShapeList shapeList;
	
	
	public RecordDrawCommand(Object Payload, ShapeList shapeList){
		this.payLoad = Payload;
		this.shapeList = shapeList;
	}
	
	public Object getPayLoad(){
		return payLoad;
	}

	@Override
	public void undo(){
		shapeList.getObservers().remove(payLoad);
		shapeList.updateCanvas();
	}

	@Override
	public void redo() {
		shapeList.getObservers().add((IDisplayableShape) payLoad);
		shapeList.updateCanvas();
		
	}

	@Override
	public void delete() {}
}
//clear
