package ControllerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IShapeListObserver;

public class ShapeList implements IShapeList {
	private List<IDisplayableShape> observers = new ArrayList<IDisplayableShape>();
	private PaintCanvas canvas;
	
	private CommandHistory commandHistory;
	private newCommand currentCommand;
	
	@Override
	public void addToList(IDisplayableShape displayableShape) {
		newCommand Command = new newCommand(displayableShape, this); // create command record
		CommandHistory.add(Command); // add to history
		observers.add(displayableShape);
		notifyObservers();
	}
	
	
	public void notifyObservers(){
		canvas.update(observers);

	}
	
	public void undoRecentObserver(Object payload){
		observers.remove(payload);
		notifyObservers();
		//canvas.updateCanvas();
}
	
	public void redoRecentObserver(Object payLoad){
		observers.add((IDisplayableShape) payLoad);
		notifyObservers();
		//canvas.updateCanvas();
	}
	

	public void registerObserver(PaintCanvas canvas) {
		this.canvas = canvas;
		
	}
	
	public void setCommandHistory(CommandHistory commandHistory){
		this.commandHistory = commandHistory;
	}
}
