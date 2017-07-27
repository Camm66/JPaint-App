package view.GuiUiModule;


import java.awt.*;

import javax.swing.JComponent;

public class PaintCanvas extends JComponent {
	private Graphics2D graphics2d;
	@Override
	public void paint(Graphics graphics){
        this.graphics2d = (Graphics2D)graphics;
        graphics2d.setColor(Color.black);
        graphics2d.fillRect(12, 13, 600, 600);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.blue);
        graphics2d.drawRect(12, 13, 600, 600);
	}
	
	//added Graphics2D 7/26
	public Graphics2D getGraphics2D(){
		return graphics2d;
	}
}
