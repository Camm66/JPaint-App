package controller;

import viewInterfaces.UIModule;

public class SelectSecondaryColorCommand implements ControllerInterface.ICommand {
    private ColorSettings _colorSettings;
    private final UIModule _uiModule;
    SelectSecondaryColorCommand(ColorSettings colorSettings, UIModule uiModule){
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }
    
    @Override
    public void run() {
        ColorAdapter color = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(color);
    }
}
