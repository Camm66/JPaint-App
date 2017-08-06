package controller;

import java.awt.Color;

import ControllerInterface.IPaintController;
import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings;

    public JPaintController(UIModule uiModule, ApplicationSettings settings){
        _uiModule = uiModule;
        _settings = settings;
        /*_settings.getDrawShapeSettings().setCurrentShape(ShapeType.ELLIPSE);
        _settings.getShadingTypeShapeSettings().setCurrentShadingType(ShadingType.OUTLINE_AND_FILLED_IN);
        _settings.getPrimaryColorShapeSettings().setCurrentColor(new ColorAdapter("Blue", Color.blue));
        _settings.getSecondaryColorShapeSettings().setCurrentColor(new ColorAdapter("Blue", Color.blue));
        _settings.getMouseModeSettings().setCurrentMouseMode(MouseMode.DRAW);*/
    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectPrimaryColorCommand( _settings.getPrimaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectSecondaryColorCommand(_settings.getSecondaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingTypeCommand(_settings.getShadingTypeShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getMouseModeSettings(), _uiModule));
    }
}
