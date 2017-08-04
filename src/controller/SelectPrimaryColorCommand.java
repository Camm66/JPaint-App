package controller;
import viewInterfaces.UIModule;

public class SelectPrimaryColorCommand implements ControllerInterface.ICommand {
    private final ColorSettings _colorSettings;
    private final UIModule _uiModule;
    SelectPrimaryColorCommand(ColorSettings colorSettings, UIModule uiModule){
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }
    
    @Override
    public void run() {
        ColorAdapter color = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(color);
    }
}

