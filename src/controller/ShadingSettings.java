package controller;

import viewInterfaces.IDialogChoice;

public class ShadingSettings implements IDialogChoice {
    private ShadingType currentShadingType = getDefaultChoice();

    void setCurrentShadingType(ShadingType newShade) {
    	if(newShade == null)
    		return;
    	else
    		this.currentShadingType = newShade;
    }

    public ShadingType getCurrentShadingType() {
        return currentShadingType;
    }

    @Override
    public String getDialogTitle() {
        return "Select a Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a Type:";
    }

    @Override
    public Object[] getDialogOptions() {
        return ShadingType.values();
    }

    @Override
    public ShadingType getDefaultChoice() {
        return ShadingType.FILLED_IN;
    }
}
