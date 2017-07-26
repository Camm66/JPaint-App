package controller;

import viewInterfaces.IDialogChoice;
import java.util.Arrays;

public class PrColorSettings implements IDialogChoice {
    private Color currentColor;

    void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    Color getCurrentColor() {
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
        return Color.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getCurrentColor();
    }
}