package main;

import ControllerInterface.IPaintController;
import controller.*;
import view.UIFactory;
import view.UIType;
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
            UIModule ui = UIFactory.createUI(UIType.GUI, settings, shapeList);
            
            IPaintController controller = new _JPaintController(ui, settings, shapeList);
            JPaint jpaintProgram = new JPaint(controller);
            jpaintProgram.run();
            
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
	}
}
