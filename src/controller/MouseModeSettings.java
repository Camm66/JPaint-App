package controller;

import viewInterfaces.IDialogChoice;

import java.util.Arrays;

import view.MouseModeFactory;

public class MouseModeSettings implements IDialogChoice {
    private MouseMode currentMouseMode;
    private MouseModeFactory mouseModeFactory;


    
    void setCurrentMouseMode(MouseMode currentMode){
        this.currentMouseMode = currentMode;
        mouseModeFactory.createMouseMode(currentMode);
        
    }

    MouseMode getCurrentMouseMode() {
        return currentMouseMode;
    }
    
    
    public void setMouseModeFactory(MouseModeFactory mouseModeFactory){
    	this.mouseModeFactory = mouseModeFactory;
    }
    
    public MouseModeFactory getMouseModeFactory(){
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
    public Object getDefaultChoice() {
        return currentMouseMode;
    }
}
