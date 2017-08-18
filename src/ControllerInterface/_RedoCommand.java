package ControllerInterface;

import viewInterfaces.UIModule;

public class _RedoCommand implements ICommand {
	private final UIModule _uiModule;
	
	public _RedoCommand(UIModule uiModule){
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		CommandHistory.redo();
	}
}
//clear