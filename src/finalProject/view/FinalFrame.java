package finalProject.view;
import javax.swing.JFrame;
import finalProject.controller.Controller;
import finalProject.view.FinalPanel;
public class FinalFrame extends JFrame
{
	private Controller app;
	private FinalPanel panel;
	/**
	 * Instantiates FinalFrame object
	 * @param app
	 * @param initRGB
	 */
	public FinalFrame(Controller app, String[] initRGB)
	{
		super();
		this.app = app;
		this.panel = new FinalPanel(this.app, initRGB);
		setupFrame();
	}
	/**
	 * Creates window to contain panel
	 */
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(800,800);
		this.setResizable(false);
		this.setTitle("Hello World");
		this.setVisible(true);;
	}
	/**
	 * return's the window's position on the display in the format of int[X,Y]
	 * @return
	 */
	public int[] getPanelPos()
	{
		int[] coords = new int[2];
		coords[0] = this.getX();
		coords[1] = this.getY();
		return coords;
	}
	/**
	 * Passes along panel.btnNewButton's position
	 * @return
	 */
	public int[] getButtonPos()
	{
		return panel.getButtonPosition();
	}
	/**
	 * Passes along order to change button location
	 * @param x
	 * @param y
	 */
	public void setButtonPos(int x, int y)
	{
		panel.setButtonPosition(x, y);
	}
}
