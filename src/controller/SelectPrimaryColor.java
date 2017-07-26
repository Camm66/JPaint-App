package controller;
import viewInterfaces.UIModule;

public class ChoosePrimaryColor implements ControllerInterface.ICommand {
    private final ColorSettings _colorSettings;
    private final UIModule _uiModule;
    ChoosePrimaryColor(ColorSettings colorSettings, UIModule uiModule){
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }
    
    @Override
    public void run() {
        Color colorChoice = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(colorChoice);
    }
}

