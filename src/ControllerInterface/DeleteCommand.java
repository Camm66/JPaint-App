package ControllerInterface;

import viewInterfaces.UIModule;

public class DeleteCommand implements ICommand{
	private final UIModule _uiModule;
	
	public DeleteCommand(UIModule uiModule){
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		System.out.println("delete pressed");
		//CommandHistory.delete();
	}


}
