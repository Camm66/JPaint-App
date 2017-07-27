package controller;
import viewInterfaces.UIModule;

public class SelectPrimaryColor implements ControllerInterface.ICommand {
    private final ColorSettings _colorSettings;
    private final UIModule _uiModule;
    SelectPrimaryColor(ColorSettings colorSettings, UIModule uiModule){
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }
    
    @Override
    public void run() {
        ColorChoice colorChoice = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(colorChoice);
    }
}

