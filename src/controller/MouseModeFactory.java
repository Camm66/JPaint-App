package controller;

import view.ShapeCloneFactory;
import view.ShapeFactory;
import view.ShapeList;
import view.GuiUiModule.*;

public class MouseModeFactory {
	private final MyMouseListener mouseListener;
	private final _CreateShapeCommand _createShapeCommand;
	private final _SelectShapesCommand _selectShapeCommand;
	private final _MoveShapesCommand _moveShapeCommand;
	
	public MouseModeFactory(ShapeFactory shapeFactory, ShapeList shapeList, PaintCanvas canvas, ShapeCloneFactory shapeCloneFactory){
		this._createShapeCommand = new _CreateShapeCommand(shapeList, shapeFactory);
		this._selectShapeCommand = new _SelectShapesCommand(shapeList);
		this._moveShapeCommand = new _MoveShapesCommand(shapeList, shapeCloneFactory);
		this.mouseListener = new MyMouseListener(_createShapeCommand);
		canvas.addMouseListener(mouseListener);
	}
	public void setMouseMode(MouseMode mouseMode){
		switch(mouseMode){
		case DRAW:
			mouseListener.setMouseListenerCommandType(_createShapeCommand);
			break;
		case MOVE:
			mouseListener.setMouseListenerCommandType(_moveShapeCommand);
			break;
		case SELECT:
			mouseListener.setMouseListenerCommandType(_selectShapeCommand);
			break;
		default:
			break;
		}
	}
}
