package view;

import java.awt.event.MouseListener;

import controller.ApplicationSettings;
import controller.CreateShapeCommand;
import model.ShapeFactory;
import model.ShapeList;
import modelInterfaces.IShapeFactory;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.DrawMouseListener;
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
                MouseListener mouseListener = new DrawMouseListener(new CreateShapeCommand(new ShapeFactory(settings, shapeList, new GuiViewShapeFactory(canvas), new DisplayableShapeFactory())));
                canvas.addMouseListener(mouseListener);
                shapeList.registerObserver(canvas);
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
