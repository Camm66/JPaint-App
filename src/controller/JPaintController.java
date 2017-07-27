package controller;

import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings = new ApplicationSettings();

    public JPaintController(UIModule uiModule){
        _uiModule = uiModule;
        _settings.getDrawShapeSettings().setCurrentShape(ShapeType.ELLIPSE);
  
    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectPrimaryColor(_settings.getPrimaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectSecondaryColor(_settings.getSecondaryColorShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingType(_settings.getShadingTypeShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseMode(_settings.getMouseModeSettings(), _uiModule));
    }
}
