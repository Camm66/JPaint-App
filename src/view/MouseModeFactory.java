package view;

import java.awt.event.MouseListener;

import ControllerInterface.ShapeList;
import controller.ApplicationSettings;
import controller.CreateShapeCommand;
import controller.MouseMode;
import model.ShapeFactory;
import view.GuiUiModule.DrawMouseListener;
import view.GuiUiModule.MoveMouseListener;
import view.GuiUiModule.PaintCanvas;
import view.GuiUiModule.SelectMouseListener;

public class MouseModeFactory {
	private final PaintCanvas canvas;
	private final MouseListener drawListener;
	private final MouseListener moveListener;
	private final MouseListener selectListener;
	private MouseListener currentListener;
	private MouseListener previousListener;
	
	public MouseModeFactory(MouseListener drawListener, MouseListener moveListener, MouseListener selectListener, PaintCanvas canvas){
		this.drawListener = drawListener;
		this.moveListener = moveListener;
		this.selectListener = selectListener;
		this.canvas = canvas;
	}
	
	public void createMouseMode(MouseMode mouseMode){
		canvas.removeMouseListener(previousListener);
		switch(mouseMode){
		case DRAW:
			currentListener = drawListener;
			break;
		case MOVE:
			currentListener = moveListener;
			break;
		case SELECT:
			currentListener = selectListener;
			break;
		default:
			currentListener = drawListener;
			}
		this.previousListener = currentListener;
		canvas.addMouseListener(currentListener);
	}
}
//rename me