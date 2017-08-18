package model;

import java.io.Serializable;

import controller.ShadingType;
import modelInterfaces.*;

public class OutlineShape implements IDisplayableShape, Serializable{
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.OUTLINE;

	
	public OutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	public void display(){
		viewShape.displayOutline(viewShape.getPrimaryColor());
	}
	
	public ShadingType getShadingType(){
		return shadingType;
	}

	@Override
	public IViewShape getShape() {
		return viewShape;
	}
}
