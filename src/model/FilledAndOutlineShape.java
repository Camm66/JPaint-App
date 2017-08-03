package model;

import modelInterfaces.*;

public class FilledAndOutlineShape implements IDisplayableShape {
	private final IViewShape viewShape;
	
	public FilledAndOutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
		viewShape.displayOutline(viewShape.getSecondaryColor());
	}
}
