package controller;

import viewInterfaces.IDialogChoice;

import java.util.Arrays;

public class ShapeSettings implements IDialogChoice {
    private ShapeType currentShape;

    void setCurrentShape(ShapeType currentShape) {
    	if(currentShape == null)
    		return;
    	else
    		this.currentShape = currentShape;
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
        return currentShape;
    }
}
