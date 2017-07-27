package controller;
import viewInterfaces.UIModule;

public class SelectSecondaryColor implements ControllerInterface.ICommand {
    private final ColorSettings _colorSettings;
    private final UIModule _uiModule;
    SelectSecondaryColor(ColorSettings colorSettings, UIModule uiModule){
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }
    
    @Override
    public void run() {
        ColorChoice colorChoice = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(colorChoice);
    }
}
