package ControllerInterface;

import controller.Point;

public interface IStartAndEndPointCommand {
	public void run(Point startingPoint, Point endingPoint) throws Exception;
}
