package modelInterfaces;

import java.io.Serializable;

public interface IDisplayableShape extends Serializable{
	public void display();

	public IViewShape getShape();

	public controller.ShadingType getShadingType(); // check

}