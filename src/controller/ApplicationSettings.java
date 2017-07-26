package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private ColorSettings shapeColorSettings = new ColorSettings();
    private ShadingSettings shapeShadingTypeSettings = new ShadingSettings();
    private MouseModeSettings shapeMouseModeSettings = new MouseModeSettings();

    ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    ColorSettings getColorShapeSettings(){
    	return shapeColorSettings;
    }
    
    ShadingSettings getShadingTypeShapeSettings(){
    	return shapeShadingTypeSettings;
    }
    
    MouseModeSettings getMouseModeSettings(){
    	return shapeMouseModeSettings;
    }
}
