package view;

import controller.ShadingType;
import modelInterfaces.*;
import model.*;

public class DisplayableShapeFactory implements IDisplayableShapeFactory {

	@Override
	public IDisplayableShape createDisplayShape(ShadingType currentShading, IViewShape viewShape) throws Exception {
		switch(currentShading){
			case OUTLINE:
				return new OutlineShape(viewShape);
			case FILLED_IN:
				return new FilledShape(viewShape);
			case OUTLINE_AND_FILLED_IN:
				return new FilledAndOutlineShape(viewShape);
			default:
				throw new Exception("Incorrect ShadingType");
		}
	}
}
