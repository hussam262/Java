import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	public static void main(String[] args) {

		try {
			CompetitorManager a = new CompetitorManager();
			a.run();
			


		//	String id = JOptionPane.showInputDialog(null, "Enter Competitor number ");

			//int idnum = Integer.parseInt(id);
			//System.out.println(a.getList().getCompList().get(4));

		}

		// Error handling for wrong entries
		catch (NumberFormatException nfe) {
			System.out.println("Value entered was not a number");
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
