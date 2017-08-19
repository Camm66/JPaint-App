package controller;

import java.util.ArrayList;
import java.util.List;

import ControllerInterface.CommandHistory;
import ControllerInterface.RecordMoveCommand;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import modelInterfaces.IStartAndEndPointCommand;
import view.ShapeCloneFactory;


public class _MoveShapesCommand implements IStartAndEndPointCommand {
	private final IShapeList _shapeList;
	private final ShapeCloneFactory _shapeCloneFactory;

	
	public _MoveShapesCommand(IShapeList shapeList, ShapeCloneFactory shapeCloneFactory){
		this._shapeList = shapeList;
		this._shapeCloneFactory = shapeCloneFactory;
	}
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception{
		if(!_shapeList.getObservers().isEmpty()){
			List<IDisplayableShape> foundShapes = _shapeList.findSelectedShape(startingPoint, endingPoint);
			List<IDisplayableShape> movedShapes = new ArrayList<IDisplayableShape>();
		
			for(IDisplayableShape foundShape : foundShapes){
				Point newStartPoint =  _shapeList.moveSelectedShape(foundShape, endingPoint);
				IDisplayableShape movedShape = _shapeCloneFactory.create(foundShape, newStartPoint, endingPoint);
				movedShapes.add(movedShape);
				_shapeList.addToList(movedShape);
				CommandHistory.add(new RecordMoveCommand(foundShape, movedShape, _shapeList));
				break;
			}	
		}
	}
}
