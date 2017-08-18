package ControllerInterface;

import java.util.List;

import controller.Point;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import modelInterfaces.IStartAndEndPointCommand;

public class _SelectShapesCommand implements IStartAndEndPointCommand {
	private final IShapeList _shapeList;
		
	public _SelectShapesCommand(IShapeList shapeList){
		this._shapeList = shapeList;
	}
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		if(startingPoint.getX() == endingPoint.getX() && startingPoint.getY() == endingPoint.getY())
			_shapeList.setSelectionPoint(endingPoint);
		else
			_shapeList.setSelectionArea(startingPoint, endingPoint);
		
		
		List<IDisplayableShape> foundShapes = _shapeList.findSelectedShape(startingPoint, endingPoint);
		if(foundShapes != null){
			for(IDisplayableShape foundShape : foundShapes){
				_shapeList.getObservers().remove(foundShape);
				_shapeList.addToList(foundShape);
				}
			_shapeList.setCurrentlySelectedShape(foundShapes);
		}
	}

}
