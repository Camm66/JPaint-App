package modelInterfaces;

import java.util.List;

import controller.Point;
import view.ShapeCloneFactory;

public interface IShapeList {

	void addToList(IDisplayableShape displayableShape);
	List<IDisplayableShape> getObservers();
	
	ShapeCloneFactory getShapeCloneFactory();
	void updateCanvas();
	
	
	List<IDisplayableShape> getCurrentlySelectedShape();
	void setCurrentlySelectedShape(List<IDisplayableShape> foundShapes);

	void setCurrentlyCopiedShape(List<IDisplayableShape> copiedShapes);
	List<IDisplayableShape> getCurrentlyCopiedShape();
	

	List<IDisplayableShape> findSelectedShape(Point startingPoint, Point endingPoint);
	
	Point moveSelectedShape(IDisplayableShape foundShape, Point endingPoint);



	Point getNewEndPoint(IDisplayableShape copiedShape, Point endPoint);
	Point getStartNewPoint(IDisplayableShape copiedShape, Point newEndPoint);

	void setSelectionPoint(Point endingPoint);
	Point getSelectionPoint();
	void setSelectionArea(Point startingPoint, Point endingPoint);
}
