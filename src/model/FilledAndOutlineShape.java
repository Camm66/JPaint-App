package model;

import controller.ShadingType;
import modelInterfaces.*;

class FilledAndOutlineShape implements IDisplayableShape{
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.OUTLINE_AND_FILLED_IN;
	
	public FilledAndOutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	@Override
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
		viewShape.displayOutline(viewShape.getSecondaryColor());
	}

	@Override
	public IViewShape getShape() {
		return viewShape;
	}
	
	@Override
	public ShadingType getShadingType(){
		return shadingType;
	}
}
