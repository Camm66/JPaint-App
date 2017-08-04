package controller;

import viewInterfaces.IDialogChoice;
import java.util.Arrays;

public class ColorSettings implements IDialogChoice {
    private ColorAdapter currentColor;

    public void setCurrentColor(ColorAdapter color) {
        this.currentColor = color;
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