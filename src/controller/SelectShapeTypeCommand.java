package controller;

import viewInterfaces.UIModule;

public class SelectShapeTypeCommand implements ControllerInterface.ICommand {
    private final ShapeSettings _shapeSettings;
    private final UIModule _uiModule;
    SelectShapeTypeCommand(ShapeSettings shapeSettings, UIModule uiModule){
        _shapeSettings = shapeSettings;
        _uiModule = uiModule;
    }

    @Override
    public void run() {
        ShapeType shapeChoice = _uiModule.getDialogResponse(_shapeSettings);
        _shapeSettings.setCurrentShape(shapeChoice);
    }
}
