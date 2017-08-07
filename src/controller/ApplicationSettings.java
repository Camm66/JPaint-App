package controller;

import java.awt.Color;

import viewInterfaces.IDialogChoice;

public class ApplicationSettings {
    private final ShapeSettings drawShapeSettings = new ShapeSettings();
    private final ColorSettings shapePrimaryColorSettings = new ColorSettings();
    private final ColorSettings shapeSecondaryColorSettings = new ColorSettings();
    private final ShadingSettings shapeShadingTypeSettings = new ShadingSettings();
    private final MouseModeSettings shapeMouseModeSettings = new MouseModeSettings();
    
    public ApplicationSettings(){
    this.drawShapeSettings.setCurrentShape(ShapeType.ELLIPSE);
    this.shapeShadingTypeSettings.setCurrentShadingType(ShadingType.OUTLINE_AND_FILLED_IN);
    this.shapePrimaryColorSettings.setCurrentColor(new ColorAdapter("Blue", Color.blue));
    this.shapeSecondaryColorSettings.setCurrentColor(new ColorAdapter("Red", Color.red));
    //this.shapeMouseModeSettings.setInitialMouseMode(MouseMode.DRAW);
    }
    
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
