package finalProject.fileManagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class IOManager
{
	private File saveData;
	private Scanner saveReader;
	private FileWriter saveWriter;
	private int pressedCount;
	/**
	 * Instantiates IOManager Object
	 */
	public IOManager()
	{
		saveData = new File("saveData.txt");
		try {
			saveReader = new Scanner(saveData);
			saveWriter = new FileWriter("saveData.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateFile();
		getFromFile();
	}
	/**
	 * Creates file or uses already created file
	 */
	private void CreateFile()
	{
		try
		{
			if(saveData.createNewFile())
			{
				System.out.println("Save File Created");
			}
			else
			{
				System.out.println("Save File Found");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Writes a value to the saveFile
	 * @param value
	 */
	public void WriteToFile(int value)
	{
		try
		{
			saveWriter.write(value);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * retrieves a value from the Save File *Not Yet Implemented*
	 */
	public void getFromFile()
	{
		pressedCount = 0;
	}
	/**
	 * Updates the current count of how many times the button was pressed
	 */
	public void updateCount()
	{
		pressedCount++;
		WriteToFile(pressedCount);
	}
	/**
	 * returns the number of times the button has been pressed
	 * @return
	 */
	public int getPressedCount()
	{
		return(pressedCount);
	}
}
