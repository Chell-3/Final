package finalProject.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import finalProject.controller.Controller;
import javax.swing.*;
import finalProject.controller.Controller;
import finalProject.fileManagement.IOManager;

public class FinalPanel extends JPanel
{
	private JButton btnNewButton;
	private IOManager ioManager;
	/**
	 * instantiates the panel, using initRGB to determine the initial background color
	 * @param app
	 * @param initRGB
	 */
	public FinalPanel(Controller app, String[] initRGB)
	{
		super();
		ioManager = new IOManager();
		setBackground(new Color(Integer.parseInt(initRGB[0]),Integer.parseInt(initRGB[1]),Integer.parseInt(initRGB[2])));
		btnNewButton = new JButton(ioManager.getPressedCount() + "");
		btnNewButton.setBounds(325, 375, 75, 25);
		add(btnNewButton);
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Guarantees a basic X/Y layout
	 */
	private void setupPanel()
	{
		this.setLayout(null);
	}
	/**
	 * Sets initial button location and label
	 */
	private void setupLayout()
	{
		btnNewButton.setLocation(362, 387);
		btnNewButton.setName(ioManager.getPressedCount() + "");
	}
	/**
	 * Changes background color when pressed. Calls IOManager to update PressedCount
	 */
	private void setupListeners()
	{
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				ioManager.updateCount();
				btnNewButton.setName(ioManager.getPressedCount() + "");
			}
		});
	}
	/**
	 * returns button's position in an integer list with the format [X,Y]
	 * @return
	 */
	public int[] getButtonPosition()
	{
		int[] coords = new int[2];
		coords[0] = btnNewButton.getX();
		coords[1] = btnNewButton.getY();
		return coords;
	}
	/**
	 * Moves the button to a new set of coordinates
	 * @param x
	 * @param y
	 */
	public void setButtonPosition(int x, int y)
	{
		btnNewButton.setLocation(x, y);
	}
}
