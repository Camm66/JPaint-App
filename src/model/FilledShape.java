package model;

import java.io.Serializable;

import controller.ShadingType;
import modelInterfaces.*;

public class FilledShape implements IDisplayableShape, Serializable{
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.FILLED_IN;
	
	public FilledShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}

	
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
	}

	public ShadingType getShadingType(){
		return shadingType;
	}

	@Override
	public IViewShape getShape() {
		return viewShape;
	}
}
