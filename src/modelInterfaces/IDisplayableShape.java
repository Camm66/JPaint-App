package modelInterfaces;

import controller.ShadingType;

public interface IDisplayableShape{
	public void display();

	public IViewShape getShape();
	
	public ShadingType getShadingType();
}