package model;

import java.io.Serializable;

import controller.ShadingType;
import modelInterfaces.*;

public class FilledAndOutlineShape implements IDisplayableShape, Serializable {
	private final IViewShape viewShape;
	private final ShadingType shadingType = ShadingType.OUTLINE_AND_FILLED_IN;
	
	public FilledAndOutlineShape(IViewShape viewShape){
		this.viewShape = viewShape;
	}
	
	public void display(){
		viewShape.displayFilled(viewShape.getPrimaryColor());
		viewShape.displayOutline(viewShape.getSecondaryColor());
	}
	
	public ShadingType getShadingType(){
		return shadingType;
	}

	@Override
	public IViewShape getShape() {
		return viewShape;
	}
}
