import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains the list of competitors
 */

public class CompetitorList {

	private ArrayList<HARCompetitor> compList;
	
	private ArrayList<HARCompetitor> sh;
	private ArrayList<HARCompetitor> m;
	private ArrayList<HARCompetitor> l;
	private ArrayList<HARCompetitor> h;
	private ArrayList<HARCompetitor> o;

	/**
	 * In the constructor the competitor details is read from the file and added to
	 * the competitor list
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public CompetitorList() throws FileNotFoundException, IOException{

		this.compList = new ArrayList<HARCompetitor>();
		this.sh=new ArrayList<HARCompetitor>();
		this.m=new ArrayList<HARCompetitor>();
		this.l=new ArrayList<HARCompetitor>();
		this.h=new ArrayList<HARCompetitor>();
		this.o=new ArrayList<HARCompetitor>();
		addCompetitors();

	}
	
    public void showGUI() {
    	//create main GUI with StaffList object
    	CompListGUI gui = new CompListGUI(this);
        gui.setVisible(true);

    }
    


	public ArrayList<HARCompetitor> getSh() {
		return sh;
	}

	public void setSh(ArrayList<HARCompetitor> sh) {
		this.sh = sh;
	}

	public ArrayList<HARCompetitor> getM() {
		return m;
	}

	public void setM(ArrayList<HARCompetitor> m) {
		this.m = m;
	}

	public ArrayList<HARCompetitor> getL() {
		return l;
	}

	public void setL(ArrayList<HARCompetitor> l) {
		this.l = l;
	}

	public ArrayList<HARCompetitor> getH() {
		return h;
	}

	public void setH(ArrayList<HARCompetitor> h) {
		this.h = h;
	}

	public ArrayList<HARCompetitor> getO() {
		return o;
	}

	public void setO(ArrayList<HARCompetitor> o) {
		this.o = o;
	}

	/**
	 * This method generates the report and writes it to the file compReport.txt
	 * 
	 * @throws FileNotFoundException
	 */
	public void addCompetitors() throws FileNotFoundException, IOException {
		try (BufferedReader in = new BufferedReader(new FileReader("compList.txt"))) {
			String str;
			while ((str = in.readLine()) != null) {
				String[] tokens = str.split("/");
				String[] scores_tokens = tokens[5].split(",");

				if (scores_tokens.length != 5) {
					continue;
				}
				processLine(str);

			}
		}
		
		
	}


	/**
	 * This method return the number of racers in each type of race
	 * 
	 * @return number of competitors in each race
	 */


	/**
	 * This method returns the Competitor list
	 * 
	 * @return Competitor List
	 */
	public ArrayList<HARCompetitor> getCompList() {
		return compList;
	}

	/**
	 * This method sets the Competitor list to a new one
	 * 
	 * @param compList replace an existing competitor list with other
	 */
	public void setCompList(ArrayList<HARCompetitor> compList) {
		this.compList = compList;
	}

	/**
	 * This method returns the competitor details based on the index in the
	 * Competitor list
	 * 
	 * @param i index of competitor in competitor list
	 * @return Competitor details
	 */
	public String compDetails(int i) {
		String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		HARCompetitor a = compList.get(i);
		return String.format(formatStr, a.getCompNum(), a.getCompName(), a.getCompLevel(), a.getRaceType(),
				a.getCompCountry(), Arrays.toString(a.getScoreArray()), a.getOverallScore());
	}

	/**
	 * This method returns the number of competitors in the list
	 * 
	 * @return number of Competitors in the list
	 */

	/**
	 * This method returns the sum of two integer arrays
	 * 
	 * @param a int array 1
	 * @param b int array 2
	 * @return sum of int array 1 and 2
	 */


	/**
	 * This method returns the short details of the competitor based on his number
	 * 
	 * @param no competitor number
	 * @return short details of the competitor
	 */
	public String getCompDetails(int no) {
		for (int i = 0; i < compList.size(); i++) {
			if (no == compList.get(i).getCompNum()) {
				return compList.get(i).getShortDetails();
			}

		}

		return "Competitor not found";
	}

	/**
	 * This method takes each line from the input , format it and add it as a
	 * competitor to the compList
	 * 
	 * @param s competitor details taken from the input file
	 */
	public void processLine(String s) {
		String[] tokens = s.split("/");
		int cnum;

		if (tokens[1].isEmpty())
			tokens[1] = "Not Available";
		if (tokens[2].isEmpty())
			tokens[2] = "N/A";
		if (tokens[3].isEmpty())
			tokens[3] = "N/A";
		if (tokens[4].isEmpty())
			tokens[4] = "N/A";
		tokens[3] = tokens[3].substring(0, 1).toUpperCase() + tokens[3].substring(1).toLowerCase();

		int[] scores = new int[5];

		String[] scores_tokens = tokens[5].split(",");

		for (int i = 0; i < 5; i++) {
			try {

				scores[i] = Integer.parseInt(scores_tokens[i]);
				if (scores[i] > 5)
					scores[i] = 5;
				if (scores[i] < 1)
					scores[i] = 1;
			} catch (NumberFormatException nfe) {
				scores[i] = 1;
			}
		}
		
		
		try {
			cnum=Integer.parseInt(tokens[0]);
		} 
		catch (NumberFormatException nfe) {
		cnum=911;
		}
			HARCompetitor a;
			if(tokens[3].equals("Short distance")) {
			 a = new ShortCompetitor(cnum, tokens[1], tokens[2], tokens[3], tokens[4],
					scores);
			sh.add(a); 
			}
			else if(tokens[3].equals("Middle distance")) {
				a = new MiddleCompetitor(cnum, tokens[1], tokens[2], tokens[3], tokens[4],
						scores);
				m.add(a);
			}
			else if(tokens[3].equals("Long distance")) {
				a = new LongCompetitor(cnum, tokens[1], tokens[2], tokens[3], tokens[4],
						scores);
				l.add(a);
			}
			else if(tokens[3].equals("Hurdle")) {
				a = new HurdleCompetitor(cnum, tokens[1], tokens[2], tokens[3], tokens[4],
						scores);
				h.add(a);
			}
			else {
				a = new OtherCompetitor(cnum, tokens[1], tokens[2], tokens[3], tokens[4],
						scores);
				o.add(a);
			}
			compList.add(a);


	}
	


}
