package modelInterfaces;
import controller.ColorAdapter;

public interface IViewShape {
	public void displayOutline(ColorAdapter color);
	public void displayFilled(ColorAdapter color);
	public ColorAdapter getPrimaryColor();
	public ColorAdapter getSecondaryColor();
}

//created 7/26