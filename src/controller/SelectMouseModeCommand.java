package controller;

import view.MouseModeFactory;
import viewInterfaces.UIModule;

public class SelectMouseModeCommand implements ControllerInterface.ICommand {
    private final MouseModeSettings _mouseModeSettings;
    private final UIModule _uiModule;
    SelectMouseModeCommand(MouseModeSettings mouseModeSettings, UIModule uiModule){
        _mouseModeSettings = mouseModeSettings;
        _uiModule = uiModule;
        }
	    
    @Override
    public void run() {
        MouseMode mouseModeChoice = _uiModule.getDialogResponse(_mouseModeSettings);
        if(mouseModeChoice == null)
        	mouseModeChoice = MouseMode.SELECT; // fix me
        _mouseModeSettings.setCurrentMouseMode(mouseModeChoice);
        }
}
