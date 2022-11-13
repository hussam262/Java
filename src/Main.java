import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main  {

	public static void main(String[] args) {

		try {
			CompetitorManager a = new CompetitorManager();
			a.run();
			
		}


		// Error handling for Input files errors
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong file path");
		}
	}
}
