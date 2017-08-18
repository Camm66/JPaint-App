package ControllerInterface;

import java.util.List;

import controller.Point;
import controller.ShapeFactory;
import controller.ShapeList;
import model.Shape;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IStartAndEndPointCommand;

public class _SelectShapesCommand implements IStartAndEndPointCommand {
	private final ShapeList _shapeList;
	private final ShapeFactory _shapeFactory;
		
	public _SelectShapesCommand(ShapeList shapeList, ShapeFactory shapeFactory){
		this._shapeList = shapeList;
		this._shapeFactory = shapeFactory;
	}
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		List<IDisplayableShape> foundShapes = _shapeList.findSelectedShape(startingPoint, endingPoint);
		
		if(startingPoint.getX() == endingPoint.getX() && startingPoint.getY() == endingPoint.getY())
			_shapeList.setSelectionPoint(endingPoint);
		else
			_shapeList.setSelectionArea(startingPoint, endingPoint);
		
		if(foundShapes != null){
			for(IDisplayableShape foundShape : foundShapes){
				_shapeList.getObservers().remove(foundShape);
				_shapeList.addToList(foundShape);
				}
			_shapeList.setCurrentlySelectedShape(foundShapes);

		}
	}

}
