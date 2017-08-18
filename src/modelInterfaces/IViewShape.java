package modelInterfaces;
import java.io.Serializable;

import controller.ColorAdapter;
import controller.ShapeType;
import model.Shape;

public interface IViewShape extends Serializable{
	public void displayOutline(ColorAdapter color);
	public void displayFilled(ColorAdapter color);
	public ColorAdapter getPrimaryColor();
	public ColorAdapter getSecondaryColor();
	public Shape getShape();
	public ShapeType getShapeType();
}

