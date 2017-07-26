package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private ColorSettings shapeColorSettings = new ColorSettings();

    ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    ColorSettings getColorShapeSettings(){
    	return shapeColorSettings;
    }
}
