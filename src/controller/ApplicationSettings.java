package controller;

public class ApplicationSettings {
    private final ShapeSettings drawShapeSettings = new ShapeSettings();
    private final ColorSettings shapePrimaryColorSettings = new ColorSettings();
    private final ColorSettings shapeSecondaryColorSettings = new ColorSettings();
    private final ShadingSettings shapeShadingTypeSettings = new ShadingSettings();
    private final MouseModeSettings shapeMouseModeSettings = new MouseModeSettings();

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
    
    public MouseModeSettings getMouseModeSettings(){
    	return shapeMouseModeSettings;
    }
    
    
}
