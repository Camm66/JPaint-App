package view;

import java.awt.event.MouseListener;

import ControllerInterface.CommandHistory;
import ControllerInterface.CreateShapeCommand;
import ControllerInterface.ShapeList;
import controller.ApplicationSettings;
import controller.MouseMode;
import model.ShapeFactory;
import modelInterfaces.IShapeFactory;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.DrawMouseListener;
import view.GuiUiModule.Gui;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;
import view.GuiUiModule.MoveMouseListener;
import view.GuiUiModule.PaintCanvas;
import view.GuiUiModule.SelectMouseListener;

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
                shapeList.setCommandHistory(new CommandHistory());
               // initializeMouseListenerFactory(DrawListener, MoveListener, SelectListener, settings, shapeList, canvas);
                MouseListener DrawListener = new DrawMouseListener(new CreateShapeCommand(new ShapeFactory(settings, shapeList, new GuiViewShapeFactory(canvas), new DisplayableShapeFactory())));
                MouseListener MoveListener = new MoveMouseListener();
                MouseListener SelectListener = new SelectMouseListener();
                MouseModeFactory mouseModeFactory = new MouseModeFactory(DrawListener, MoveListener, SelectListener, canvas);
                settings.getMouseModeSettings().setMouseModeFactory(mouseModeFactory);
                settings.getMouseModeSettings().getMouseModeFactory().createMouseMode(MouseMode.DRAW);
                
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
