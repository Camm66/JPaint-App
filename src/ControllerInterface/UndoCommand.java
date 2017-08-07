package ControllerInterface;

import controller.ColorAdapter;
import viewInterfaces.UIModule;

public class UndoCommand implements ICommand {
    private final UIModule _uiModule;
    
    public UndoCommand(UIModule uiModule){
    	_uiModule = uiModule;
    }


	@Override
	public void run() {
		System.out.println("Undo Pressed");
		CommandHistory.undo();
	}

}
