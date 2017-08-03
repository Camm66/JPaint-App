package controller;

import viewInterfaces.IDialogChoice;
import java.util.Arrays;

public class ColorSettings implements IDialogChoice {
    private ColorAdapter currentColor;

    void setCurrentColor(ColorAdapter currentColor) {
        this.currentColor = currentColor;
    }

    public ColorAdapter getCurrentColor() {
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