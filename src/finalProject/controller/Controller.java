package finalProject.controller;
import finalProject.view.FinalFrame;
import finalProject.view.MouseListener;
public class Controller
{
	private FinalFrame frame;
	private MouseListener mouse;
	private int[] relativeM;
	private int[] buttonPos;
	private int[] BMDist;
	/**
	 * Instantiates the Controller Object
	 * @param args
	 */
	public Controller(String[] args)
	{
		frame = new FinalFrame(this, args);
		mouse = new MouseListener();
		relativeM = new int[2];
	}
	/**
	 * Method called to start the program. Starts button movement if mouse is in range of it.
	 */
	public void start()
	{
		while(true)
		{
			relativeM[0] = mouse.getPos()[0]-frame.getPanelPos()[0];
			relativeM[1] = mouse.getPos()[1]-frame.getPanelPos()[1];
			buttonPos = frame.getButtonPos();
			if(calculateBMDist()<=150)
			{
				repulse();
			}
		}
	}
	/**
	 * Calculates the absolute x and y distances from the mouse to the button compensating for the button's size
	 * @returns distance
	 */
	private double calculateBMDist()
	{
		return(Math.abs(buttonPos[0]-relativeM[0]+37.5) + Math.abs(buttonPos[1]-relativeM[1]+12.5));
	}
	/**
	 * Moves the button away from the mouse using the button's setButtonPos method
	 */
	private void repulse()
	{
		if(buttonPos[0]>relativeM[0]&&buttonPos[1]>relativeM[1])
		{
			frame.setButtonPos(buttonPos[0]+5, buttonPos[1]+5);
		}
		else if(buttonPos[0]<relativeM[0]&&buttonPos[1]>relativeM[1])
		{
			frame.setButtonPos(buttonPos[0]-5, buttonPos[1]+5);
		}
		else if(buttonPos[0]>relativeM[0]&&buttonPos[1]<relativeM[1])
		{
			frame.setButtonPos(buttonPos[0]+5, buttonPos[1]-5);
		}
		else if(buttonPos[0]<relativeM[0]&&buttonPos[1]<relativeM[1])
		{
			frame.setButtonPos(buttonPos[0]-5, buttonPos[1]-5);
		}
	}
}
