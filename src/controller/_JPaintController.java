package controller;

import ControllerInterface._CopyCommand;
import ControllerInterface._DeleteCommand;
import ControllerInterface.IPaintController;
import ControllerInterface._PasteCommand;
import ControllerInterface._RedoCommand;
import ControllerInterface._UndoCommand;
import modelInterfaces.IShapeList;
import view.ShapeList;
import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class _JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings;
    private final IShapeList _shapeList;

    public _JPaintController(UIModule ui, ApplicationSettings settings, IShapeList shapeList) {
        _uiModule = ui;
        _settings = settings;
        _shapeList = shapeList;
	}

	@Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeTypeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectPrimaryColorCommand( _settings.getPrimaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectSecondaryColorCommand(_settings.getSecondaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingTypeCommand(_settings.getShadingTypeShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getMouseModeSettings(), _uiModule));
        _uiModule.addEvent(EventName.UNDO, new _UndoCommand());
        _uiModule.addEvent(EventName.REDO, new _RedoCommand());
        _uiModule.addEvent(EventName.COPY, new _CopyCommand(_shapeList));
        _uiModule.addEvent(EventName.PASTE, new _PasteCommand(_shapeList));
        _uiModule.addEvent(EventName.DELETE, new _DeleteCommand((ShapeList) _shapeList));
    }
}

