package ControllerInterface;

import viewInterfaces.UIModule;

public class RedoCommand implements ICommand {
	private final UIModule _uiModule;
	public RedoCommand(UIModule uiModule){
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		CommandHistory.redo();
	}

}
