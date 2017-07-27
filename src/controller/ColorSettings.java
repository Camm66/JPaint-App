package controller;

import viewInterfaces.IDialogChoice;
import java.util.Arrays;

public class ColorSettings implements IDialogChoice {
    private ColorChoice currentColor;

    void setCurrentColor(ColorChoice currentColor) {
        this.currentColor = currentColor;
    }

    ColorChoice getCurrentColor() {
        return currentColor;
    }

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
        return ColorChoice.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getCurrentColor();
    }
}