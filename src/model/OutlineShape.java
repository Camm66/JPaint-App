package model;

import controller.ShadingType;
import modelInterfaces.*;

public class OutlineShape implements IDisplayableShape {
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.OUTLINE;

	
	public OutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	@Override
	public void display(){
		viewShape.displayOutline(viewShape.getPrimaryColor());
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
