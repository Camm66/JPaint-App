package view;


import controller.ApplicationSettings;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;
import view.GuiUiModule.PaintCanvas;

public class UIFactory {
    public static UIModule createUI(UIType uiType, ApplicationSettings settings, ShapeList shapeList, PaintCanvas canvas) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
                ui = new Gui(new GuiWindow(canvas));   
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
