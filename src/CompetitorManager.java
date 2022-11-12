import java.io.FileNotFoundException;
import java.io.IOException;

public class CompetitorManager {
	private CompetitorList list;

	/**
	 * The constructor initializes the competitor list
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public CompetitorManager() throws FileNotFoundException, IOException {
		list = new CompetitorList();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method creates the competitor report
	 * 
	 * @throws FileNotFoundException
	 */
	public void run() throws FileNotFoundException {
		list.showGUI();
	

	}

	/**
	 * This method returns the list of competitors
	 * 
	 * @return
	 */
	public CompetitorList getList() {
		return list;
	}

	/**
	 * This method sets the list of competitors
	 * 
	 * @param list
	 */
	public void setList(CompetitorList list) {
		this.list = list;
	}

}
