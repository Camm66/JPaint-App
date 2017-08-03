package main;

import controller.*;
import controller.JPaintController;
import view.GuiUiModule.Gui;
import view.UIFactory;
import view.UIType;
import viewInterfaces.UIModule;
import model.*;

public class Main {

	public static void main(String[] args) {

        try {
            /*if(args.length == 0)
                throw new Exception("Must specify ui switch.\nex: \"-ui=[GUI][CMD]\"");

            UISelector selector = new UISelector();
            UIModule ui = selector.getUi(args[0]);*/
        	ApplicationSettings settings = new ApplicationSettings();
        	ShapeList shapeList = new ShapeList();
            UIModule ui = UIFactory.createUI(UIType.GUI, settings, shapeList);
            IPaintController controller = new JPaintController(ui);
            JPaint jpaintProgram = new JPaint(controller);
            jpaintProgram.run();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
	}
}
