package controller;

import java.awt.Color;

import ControllerInterface.IPaintController;
import ControllerInterface.RedoCommand;
import ControllerInterface.UndoCommand;
import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings;

    public JPaintController(UIModule uiModule, ApplicationSettings settings){
        _uiModule = uiModule;
        _settings = settings;
    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectPrimaryColorCommand( _settings.getPrimaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectSecondaryColorCommand(_settings.getSecondaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingTypeCommand(_settings.getShadingTypeShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getMouseModeSettings(), _uiModule));
        _uiModule.addEvent(EventName.UNDO, new UndoCommand(_uiModule));
        _uiModule.addEvent(EventName.REDO, new RedoCommand(_uiModule));
        //_uiModule.addEvent(EventName.COPY, new CopyCommand(_uiModule));
        //_uiModule.addEvent(EventName.PASTE, new PasteCommand(_uiModule));
        //_uiModule.addEvent(EventName.DELETE, new DeleteCommand(_uiModule));
    }
}
