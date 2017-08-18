package ControllerInterface;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;

public class RecordDrawCommand implements IUndoable{
	private Object payLoad;
	private final IShapeList shapeList;
	
	
	public RecordDrawCommand(Object Payload, IShapeList shapeList){
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