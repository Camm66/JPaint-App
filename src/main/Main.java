package main;

import ControllerInterface.IPaintController;
import controller.*;
import view.DisplayableShapeFactory;
import view.GuiViewShapeFactory;
import view.ShapeCloneFactory;
import view.ShapeFactory;
import view.ShapeList;
import view.UIFactory;
import view.UIType;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.UIModule;

public class Main {

	public static void main(String[] args) {

        try {
            /*ifargs.length == 0)
                throw new Exception("Must specify ui switch.\nex: \"-ui=[GUI][CMD]\"");

            UISelector selector = new UISelector();
            UIModule ui = selector.getUi(args[0]);*/
        	ApplicationSettings settings = new ApplicationSettings();
        	ShapeList shapeList = new ShapeList();
        	PaintCanvas canvas = new PaintCanvas();

        	
            UIModule ui = UIFactory.createUI(UIType.GUI, settings, shapeList, canvas);
            
          
            shapeList.registerObserver(canvas);            
            GuiViewShapeFactory viewShapeFactory = new GuiViewShapeFactory(canvas);
            DisplayableShapeFactory displayableShapeFactory = new DisplayableShapeFactory();
            ShapeFactory shapeFactory = new ShapeFactory(settings, shapeList, viewShapeFactory, displayableShapeFactory);
            ShapeCloneFactory shapeCloneFactory = new ShapeCloneFactory(viewShapeFactory, displayableShapeFactory);
            shapeList.setShapeCloneFactory(shapeCloneFactory);
            MouseModeFactory mouseModeFactory = new MouseModeFactory(shapeFactory, shapeList, canvas, shapeCloneFactory);
            settings.getMouseModeSettings().setMouseModeFactory(mouseModeFactory);
            
            
            IPaintController controller = new JPaintController(ui, settings, shapeList);
            JPaint jpaintProgram = new JPaint(controller);
            jpaintProgram.run();
            
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
	}
}
