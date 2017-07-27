package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private ColorSettings shapePrimaryColorSettings = new ColorSettings();
    private ColorSettings shapeSecondaryColorSettings = new ColorSettings();
    private ShadingSettings shapeShadingTypeSettings = new ShadingSettings();
    private MouseModeSettings shapeMouseModeSettings = new MouseModeSettings();

    ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    ColorSettings getPrimaryColorShapeSettings(){
    	return shapePrimaryColorSettings;
    }
    
    ColorSettings getSecondaryColorShapeSettings(){
    	return shapeSecondaryColorSettings;
    }
    
    ShadingSettings getShadingTypeShapeSettings(){
    	return shapeShadingTypeSettings;
    }
    
    MouseModeSettings getMouseModeSettings(){
    	return shapeMouseModeSettings;
    }
}
