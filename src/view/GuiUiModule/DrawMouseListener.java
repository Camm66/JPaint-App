package view.GuiUiModule;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import controller.Point;
import modelInterfaces.IStartAndEndPointCommand;

public class DrawMouseListener extends MouseInputAdapter{
	private Point startingPoint;
	private Point endingPoint;
	private final IStartAndEndPointCommand command;
	
	public DrawMouseListener(IStartAndEndPointCommand command){
		this.command = command;
	}
	
	public void mousePressed(MouseEvent mouseEvent){
		startingPoint = new Point(mouseEvent.getX(), mouseEvent.getY());
	}
	
	public void mouseReleased(MouseEvent mouseEvent){
		endingPoint = new Point(mouseEvent.getX(), mouseEvent.getY());
		try{
			command.run(startingPoint, endingPoint);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
