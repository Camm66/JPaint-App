package ControllerInterface;


public class _UndoCommand implements ICommand {
    
    public _UndoCommand(){ }

	@Override
	public void run(){
		CommandHistory.undo();
	}
}