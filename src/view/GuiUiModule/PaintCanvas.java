package view.GuiUiModule;

import modelInterfaces.*;
import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class PaintCanvas extends JComponent {
	/*private Graphics2D graphics2d;
	@Override
	public void paint(Graphics graphics){
        this.graphics2d = (Graphics2D)graphics;
        graphics2d.setColor(Color.black);
        graphics2d.fillRect(12, 13, 600, 600);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.blue);
        graphics2d.drawRect(12, 13, 600, 600);
	}*/
	
	//added Graphics2D 7/26
	
	public void update(List<IDisplayableShape> shapes){
		for(IDisplayableShape shape : shapes)
			shape.display();
	}
	
	public Graphics2D getGraphics2D(){
		return (Graphics2D)getGraphics();
	}
	
	public void addMouseListener(MouseListener mouseListener){
		
	}
}
