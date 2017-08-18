package ControllerInterface;

import viewInterfaces.UIModule;

public class _UndoCommand implements ICommand {
    private final UIModule _uiModule;
    
    public _UndoCommand(UIModule uiModule){
    	_uiModule = uiModule;
    }


	@Override
	public void run(){
		CommandHistory.undo();
	}
}
//cleared