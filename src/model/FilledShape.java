package model;

import modelInterfaces.*;

public class FilledShape implements IDisplayableShape {
	private final IViewShape viewShape;
	
	public FilledShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
	}
}
