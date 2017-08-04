package viewInterfaces;

import java.util.List;
import java.awt.List;
import modelInterfaces.*;

public interface IShapeListObserver {
	public void update(List<IDisplayableShape> shapes);
}
