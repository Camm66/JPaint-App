package controller;

import ControllerInterface.CommandHistory;
import ControllerInterface.ICommand;

public class _RedoCommand implements ICommand {
	
	public _RedoCommand(){}
	
	@Override
	public void run() {
		CommandHistory.redo();
	}
}