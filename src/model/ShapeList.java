package model;

import java.util.ArrayList;
import java.util.List;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IShapeListObserver;

public class ShapeList implements IShapeList {
	private List<IDisplayableShape> observers = new ArrayList<IDisplayableShape>();
	private PaintCanvas canvas;
	
	@Override
	public void addToList(IDisplayableShape displayableShape) {

		observers.add(displayableShape);
		notifyObservers();
	}
	/*
	public void removeFromList(IDisplayableShape displayableShape) {
		observers.remove(displayableShape);

	}*/
	public void notifyObservers(){
		canvas.update(observers);
	}
	

	public void registerObserver(PaintCanvas canvas) {
		this.canvas = canvas;
		
	}
}
