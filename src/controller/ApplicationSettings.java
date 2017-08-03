package controller;

import viewInterfaces.IDialogChoice;

public class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private ColorSettings shapePrimaryColorSettings = new ColorSettings();
    private ColorSettings shapeSecondaryColorSettings = new ColorSettings();
    private ShadingSettings shapeShadingTypeSettings = new ShadingSettings();
    private MouseModeSettings shapeMouseModeSettings = new MouseModeSettings();

    public ApplicationSettings(){}
    
    public ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    public ColorSettings getPrimaryColorShapeSettings(){
    	return shapePrimaryColorSettings;
    }
    
    public ColorSettings getSecondaryColorShapeSettings(){
    	return shapeSecondaryColorSettings;
    }
    
    public ShadingSettings getShadingTypeShapeSettings(){
    	return shapeShadingTypeSettings;
    }
    
    MouseModeSettings getMouseModeSettings(){
    	return shapeMouseModeSettings;
    }
}
