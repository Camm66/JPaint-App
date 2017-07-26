package controller;

import viewInterfaces.IDialogChoice;

import java.util.Arrays;

public class MouseModeSettings implements IDialogChoice {
    private MouseMode currentMouseMode;

    void setCurrentShadingType(MouseMode currentMode) {
        this.currentMouseMode = currentMode;
    }

    MouseMode getCurrentMouseMode() {
        return currentMouseMode;
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
        return getCurrentMouseMode();
    }
}
