package model;

import controller.ShadingType;
import modelInterfaces.*;

class FilledShape implements IDisplayableShape {
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.FILLED_IN;
	
	public FilledShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}

	@Override
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
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
