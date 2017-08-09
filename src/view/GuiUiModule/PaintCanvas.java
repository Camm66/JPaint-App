package view.GuiUiModule;

import modelInterfaces.*;
import viewInterfaces.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;

public class PaintCanvas extends JComponent implements IShapeListObserver {
	private MouseListener mouseListener;
	
	
	public void update(List<IDisplayableShape> shapes){
		for(IDisplayableShape shape : shapes){
			shape.display();
		}
	}
	
	
	public Graphics2D getGraphics2D(){
		return (Graphics2D)getGraphics();
	}
}
