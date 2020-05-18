package finalProject.view;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;

public class MouseListener extends MouseAdapter
{
	public int[] getPos()
	{
		int[] coords = new int[2];
		coords[0] = MouseInfo.getPointerInfo().getLocation().x;
		coords[1] = MouseInfo.getPointerInfo().getLocation().y;
		return(coords);
	}
}
