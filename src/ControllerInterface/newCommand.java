package ControllerInterface;

import modelInterfaces.IDisplayableShape;

public class newCommand implements IUndoable{
	private Object payLoad;
	private final ShapeList shapeList;
	
	
	public newCommand(Object Payload, ShapeList shapeList){
		this.payLoad = Payload;
		this.shapeList = shapeList;
	}
	
	public Object getPayLoad(){
		return payLoad;
	}

	@Override
	public void undo() {
		shapeList.undoRecentObserver(payLoad);
	}

	@Override
	public void redo() {
		shapeList.redoRecentObserver(payLoad);
		
	}

}
