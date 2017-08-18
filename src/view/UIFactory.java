package view;


import controller.ApplicationSettings;
import controller.ShapeFactory;
import controller.ShapeList;
import model.ShapeCloneFactory;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;
import view.GuiUiModule.PaintCanvas;

public class UIFactory {
    public static UIModule createUI(UIType uiType, ApplicationSettings settings, ShapeList shapeList) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
            	PaintCanvas canvas = new PaintCanvas();
                ui = new Gui(new GuiWindow(canvas));   
                shapeList.registerObserver(canvas);
                
                
                
                GuiViewShapeFactory viewShapeFactory = new GuiViewShapeFactory(canvas);
                DisplayableShapeFactory displayableShapeFactory = new DisplayableShapeFactory();
                ShapeFactory shapeFactory = new ShapeFactory(settings, shapeList, viewShapeFactory, displayableShapeFactory);
                ShapeCloneFactory shapeCloneFactory = new ShapeCloneFactory(viewShapeFactory, displayableShapeFactory);
                shapeList.setShapeCloneFactory(shapeCloneFactory);
                MouseModeFactory mouseModeFactory = new MouseModeFactory(shapeFactory, shapeList, canvas, shapeCloneFactory);
                settings.getMouseModeSettings().setMouseModeFactory(mouseModeFactory);
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
