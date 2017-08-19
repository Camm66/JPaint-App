package controller;

import ControllerInterface.CommandHistory;
import ControllerInterface.IStartAndEndPointCommand;
import ControllerInterface.RecordDrawCommand;
import modelInterfaces.*;

public class _CreateShapeCommand implements IStartAndEndPointCommand {
	private final IShapeFactory shapeFactory;
	private final IShapeList shapeList;
	
	public _CreateShapeCommand(IShapeList shapeList, IShapeFactory shapeFactory){
		this.shapeFactory = shapeFactory;
		this.shapeList = shapeList;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		RecordDrawCommand Command = new RecordDrawCommand(shapeFactory.create(startingPoint, endingPoint), shapeList);
		CommandHistory.add(Command);
	}	
}
