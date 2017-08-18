package view.GuiUiModule;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import controller.Point;
import modelInterfaces.IStartAndEndPointCommand;

public class MyMouseListener extends MouseInputAdapter{
	private Point startingPoint;
	private Point endingPoint;
	private IStartAndEndPointCommand command;
	
	public MyMouseListener(IStartAndEndPointCommand command){
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
	
	public void setMouseListenerCommandType(IStartAndEndPointCommand command){
		this.command = command;
	}

	
	
}
