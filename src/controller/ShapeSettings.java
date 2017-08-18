package controller;

import viewInterfaces.IDialogChoice;

public class ShapeSettings implements IDialogChoice {
    private ShapeType currentShape = getDefaultChoice();

    void setCurrentShape(ShapeType newShape) {
    	if(newShape == null)
    		return;
    	else
    		this.currentShape = newShape;
    }

    public ShapeType getCurrentShape() {
        return currentShape;
    }

    @Override
    public String getDialogTitle() {
        return "Select a Shape";
    }

    @Override
    public String getDialogText() {
        return "Select a Shape:";
    }

    @Override
    public Object[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public ShapeType getDefaultChoice() {
        return ShapeType.ELLIPSE;
    }
}
