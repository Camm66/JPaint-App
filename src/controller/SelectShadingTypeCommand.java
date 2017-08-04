package controller;

import viewInterfaces.UIModule;

public class SelectShadingTypeCommand implements ControllerInterface.ICommand {
    private final ShadingSettings _shadeSettings;
    private final UIModule _uiModule;
    SelectShadingTypeCommand(ShadingSettings shadeSettings, UIModule uiModule){
        _shadeSettings = shadeSettings;
        _uiModule = uiModule;
    }
	    
    @Override
    public void run() {
        ShadingType shadeChoice = _uiModule.getDialogResponse(_shadeSettings);
        _shadeSettings.setCurrentShadingType(shadeChoice);
    }
}

