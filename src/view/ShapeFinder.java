package view;

import java.util.ArrayList;
import java.util.List;

import controller.Point;
import model.Shape;
import modelInterfaces.IDisplayableShape;

public class ShapeFinder {
	public List<IDisplayableShape> findSelectedShape(Point startingPoint, Point endingPoint, List <IDisplayableShape> observers){
		List<IDisplayableShape> foundShapes = new ArrayList<IDisplayableShape>();
		Shape inputShape = new Shape(null, null, startingPoint, endingPoint);
		
		if((startingPoint.getX() == endingPoint.getX()) && (startingPoint.getY() == endingPoint.getY())){
			for(IDisplayableShape observer : observers){
				Shape observerShape = observer.getShape().getShape();
				if(collisionDetected(observerShape, inputShape)){
					foundShapes.add(observer);
					return foundShapes;
				}
			}
		}
		else{
			for(IDisplayableShape observer : observers){
				Shape observerShape = observer.getShape().getShape();
				if(collisionDetected(observerShape, inputShape))
					foundShapes.add(observer);
			}
		}
		return foundShapes;
	}
	
	private boolean collisionDetected(Shape observerShape, Shape inputShape){
		if(inputShape.getStartX() < observerShape.getStartX() + observerShape.getWidth()
		&& inputShape.getStartX() + inputShape.getWidth() > observerShape.getStartX() 
		&& inputShape.getStartY() < observerShape.getStartY() + observerShape.getHeight() 
		&& inputShape.getStartY() + inputShape.getHeight() > observerShape.getStartY())
			return true;
		else
			return false;
	}
}