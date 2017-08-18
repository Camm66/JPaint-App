package ControllerInterface;

public class _RedoCommand implements ICommand {
	
	public _RedoCommand(){}
	
	@Override
	public void run() {
		CommandHistory.redo();
	}
}