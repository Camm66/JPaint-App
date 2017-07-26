package controller;

import viewInterfaces.UIModule;

public class SelectMouseMode implements ControllerInterface.ICommand {
    private final MouseModeSettings _mouseModeSettings;
    private final UIModule _uiModule;
    SelectMouseMode(MouseModeSettings mouseModeSettings, UIModule uiModule){
        _mouseModeSettings = mouseModeSettings;
        _uiModule = uiModule;
    }
	    
    @Override
    public void run() {
        MouseMode mouseModeChoice = _uiModule.getDialogResponse(_mouseModeSettings);
        _mouseModeSettings.setCurrentShadingType(mouseModeChoice);
    }
}
