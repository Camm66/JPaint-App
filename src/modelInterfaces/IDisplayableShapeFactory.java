package modelInterfaces;

import controller.ShadingType;

public interface IDisplayableShapeFactory {

	IDisplayableShape createDisplayShape(ShadingType currentShading, IViewShape viewShape);

}
