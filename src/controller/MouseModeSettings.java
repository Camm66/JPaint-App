package controller;

import viewInterfaces.IDialogChoice;

public class MouseModeSettings implements IDialogChoice {
    private MouseMode currentMouseMode = getDefaultChoice();
    private MouseModeSwitcher mouseModeFactory;


    
   public void setCurrentMouseMode(MouseMode newMode){
	   	if(newMode == null)
	   		this.currentMouseMode = getDefaultChoice();
	   	else {
	   		this.currentMouseMode = newMode;
	   		mouseModeFactory.setMouseMode(newMode);
	   	}
    }

    MouseMode getCurrentMouseMode() {
        return currentMouseMode;
    }
    
    
    public void setMouseModeFactory(MouseModeSwitcher mouseModeFactory){
    	this.mouseModeFactory = mouseModeFactory;
    }
    
    public MouseModeSwitcher getMouseModeFactory(){
    	return mouseModeFactory;
    }

    @Override
    public String getDialogTitle() {
        return "Select a Mouse Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a Mode:";
    }

    @Override
    public Object[] getDialogOptions() {
        return MouseMode.values();
    }

    @Override
    public MouseMode getDefaultChoice() {
        return MouseMode.DRAW;
    }
}
