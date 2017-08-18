package view.GuiUiModule;

import modelInterfaces.*;
import viewInterfaces.*;

import java.awt.*;
import java.util.List;
import javax.swing.JComponent;

public class PaintCanvas extends JComponent implements IShapeListObserver {
	private MyMouseListener mouseListener;
	
	public void update(List<IDisplayableShape> shapes){
		for(IDisplayableShape shape : shapes){
			shape.display();
		}
	}
	
	public Graphics2D getGraphics2D(){
		return (Graphics2D)getGraphics();
	}
}
