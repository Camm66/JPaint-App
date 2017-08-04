package model;

import modelInterfaces.*;

public class OutlineShape implements IDisplayableShape {
	private final IViewShape viewShape;
	
	public OutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	public void display(){
		viewShape.displayOutline(viewShape.getPrimaryColor());
	}
}
