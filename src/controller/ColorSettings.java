package controller;

import viewInterfaces.IDialogChoice;

import java.awt.Color;

public class ColorSettings implements IDialogChoice {
    private ColorAdapter currentColor;
    
    public void setCurrentColor(ColorAdapter currentColor) {
    	if(currentColor == null)
    		return;
    	else
    		this.currentColor = currentColor;   
    	}

    public ColorAdapter getCurrentColor() {
        return currentColor;
    }

    
    
    public static ColorAdapter[] colorChoices = {
    		new ColorAdapter("Red", Color.red), 
    		new ColorAdapter("Blue", Color.blue),
    		new ColorAdapter("Green", Color.green)
    }; 
    
    
    
    @Override
    public String getDialogTitle() {
        return "Select a Color";
    }

    @Override
    public String getDialogText() {
        return "Select a Color:";
    }

    @Override
    public Object[] getDialogOptions() {
    	return colorChoices;
    }

    @Override
    public Object getDefaultChoice() {
        return currentColor;
    }
}