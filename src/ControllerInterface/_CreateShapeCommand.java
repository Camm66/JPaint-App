package ControllerInterface;

import controller.Point;
import controller.ShapeList;
import modelInterfaces.*;

public class _CreateShapeCommand implements IStartAndEndPointCommand {
	private final IShapeFactory shapeFactory;
	private final ShapeList shapeList;
	
	public _CreateShapeCommand(ShapeList shapeList, IShapeFactory shapeFactory){
		this.shapeFactory = shapeFactory;
		this.shapeList = shapeList;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		RecordDrawCommand Command = new RecordDrawCommand(shapeFactory.create(startingPoint, endingPoint), shapeList); // create command record
		CommandHistory.add(Command); // add to history
	}	
}
//clear
