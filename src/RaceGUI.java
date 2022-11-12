import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RaceGUI extends JFrame  implements ActionListener{
    private ArrayList<HARCompetitor> compList;
    
    //GUI components
    JTextField result;
    JTextField searchField;
    JButton search;
    JScrollPane scrollList;
    JButton showListByCompNo, showListByName, showListByOverall, createReport;
    JTextArea displayList;
    JTable table;
    public RaceGUI(ArrayList<HARCompetitor> list)
    {
        this.compList = list;
        
        //set up window title
        setTitle("Competitor List");
        //disable standard close button
		//setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
 
		setupSouthPanel();
		setupNorthPanel();
		setupCenterPanel();
		setPreferredSize(new Dimension(1300, 500));
		originList();
        getRootPane().setBorder(
                BorderFactory.createMatteBorder(3, 3, 3, 3,Color.WHITE));
        //pack and set visible
        pack();
        setVisible(true);

    }
    
    private void setupCenterPanel() {
    	String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
    	String column[]={"ID","NAME","SALARY"};         
    	JTable jt=new JTable(data,column);    
    	jt.setBounds(30,40,200,300);          
    	JScrollPane sp=new JScrollPane(jt);    

        displayList = new JTextArea(15,20);
        displayList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
        displayList.setEditable(true);
        scrollList = new JScrollPane(displayList);
        this.add(scrollList,BorderLayout.CENTER);
    }
    
    private void setupSouthPanel() {
        //search panel contains label, text field and button
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 1, 20, 20));
        searchPanel.add(new JLabel("Enter Comp No."));   
        searchField = new JTextField(5);
        searchPanel.add(searchField);   
        search = new JButton("Search");  
        searchPanel.add(search);    
        //specify action when button is pressed
        search.addActionListener(this) ;
        
        //Set up the area where the results will be displayed.
        result= new JTextField(25);     
        result.setEditable(false);
        
        //set up south panel containing 2 previous areas
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(searchPanel);
        southPanel.add(result);
        
        //add south panel to the content pane
        this.add(southPanel, BorderLayout.SOUTH);   	
    }
    
    private void setupNorthPanel() {
        //add north panel containing some buttons
        JPanel northPanel = new JPanel();
        showListByCompNo = new JButton("List By Comp No");
        showListByCompNo.addActionListener(this);
        
        showListByName = new JButton("List By Name");
        showListByName.addActionListener(this);
        
        showListByOverall = new JButton("List By Overall Score");
        showListByOverall.addActionListener(this);
        
        createReport = new JButton("Create Report");
        createReport.addActionListener(this);
        northPanel.setLayout(new GridLayout(1, 1, 20, 20));
        northPanel.add (showListByCompNo);
        northPanel.add(showListByName);
        northPanel.add(showListByOverall);
        northPanel.add(createReport);
        this.add(northPanel, BorderLayout.NORTH);
    }
    
    //come here when button is clicked
    //find which button and act accordingly
    public void actionPerformed(ActionEvent e) 
    { 
    	if (e.getSource() == search) {
    		search();
    	}
    	else if (e.getSource() == showListByCompNo) {
    		listByID();
    		
    	}
    	else if (e.getSource() == showListByName ) {
    		listByName();
    	}
    	else if (e.getSource() == showListByOverall) {
    		listByOverall();
    	}
    	else if (e.getSource() == createReport) {
    		try {
				compReport();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		JOptionPane.showMessageDialog(null, "Report Created Successfully");
    	}
    } 
    
    public void originList() {
        String s;		
        String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		
				s=String.format(formatStr, "No.", "Name", "Level", "Race Type", "Country", "Scores", "Overall Score");
s+=" \n";
		for (int i = 0; i < compList.size(); i++) {
			s+=(compDetails(i))+" \n";

		}
        displayList.setText(s);
    }
    public void listByID()
    {
        compList.sort(Comparator.comparing(HARCompetitor::getCompNum));
        String s;		
        String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		
				s=String.format(formatStr, "No.", "Name", "Level", "Race Type", "Country", "Scores", "Overall Score");
s+=" \n";
		for (int i = 0; i < compList.size(); i++) {
			s+=(compDetails(i))+" \n";

		}
        displayList.setText(s);
    }
    
    public void listByName()
    {
        compList.sort(Comparator.comparing(HARCompetitor::getCompName));
        String s;		
        String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		
				s=String.format(formatStr, "No.", "Name", "Level", "Race Type", "Country", "Scores", "Overall Score");
s+=" \n";
		for (int i = 0; i < compList.size(); i++) {
			s+=(compDetails(i))+" \n";

		}
        displayList.setText(s);
    }
    public void listByOverall()
    {
        compList.sort(Comparator.comparing(HARCompetitor::getOverallScore));
        String s;		
        String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		
				s=String.format(formatStr, "No.", "Name", "Level", "Race Type", "Country", "Scores", "Overall Score");
s+=" \n";
		for (int i = 0; i < compList.size(); i++) {
			s+=(compDetails(i))+" \n";

		}
        displayList.setText(s);
    }

	public String compDetails(int i) {
		String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		HARCompetitor a = compList.get(i);
		return String.format(formatStr, a.getCompNum(), a.getCompName(), a.getCompLevel(), a.getRaceType(),
				a.getCompCountry(), Arrays.toString(a.getScoreArray()), a.getOverallScore());
	}
	
	public void compReport() throws FileNotFoundException {

		PrintStream out = new PrintStream(new FileOutputStream("compReport.txt"));
		String formatStr = "%-10s %-30s %-20s %-20s %-20s %-20s %-20s";
		out.println(
				String.format(formatStr, "No.", "Name", "Level", "Race Type", "Country", "Scores", "Overall Score"));

		for (int i = 0; i < compList.size(); i++) {
			out.println(compDetails(i));

		}
		out.println();
		out.println("There is a total of " + numberCompetitors() + " Competitors");
		out.println(highestScore());
		out.println(lowestScore());
		out.println(averageScore());
		out.println();
		out.println(freqReport());
		out.println();
		out.println(numInEachRace());

		out.close();
	}
	
	public String numInEachRace() {
		int maxTypes = 5;
		String[] typeNames = { "Short distance", "Middle distance", "Long distance", "Hurdle", "Others" };
		int[] freqRace = new int[maxTypes];
		String report = "Number of Racers in each type : \n";
		;

		for (int i = 0; i < compList.size(); i++) {

			if (compList.get(i).getRaceType().equals("Short distance")) {
				freqRace[0]++;
			}

			else if (compList.get(i).getRaceType().equals("Middle distance")) {
				freqRace[1]++;
			}

			else if (compList.get(i).getRaceType().equals("Long distance")) {
				freqRace[2]++;
			} else if (compList.get(i).getRaceType().equals("Hurdle")) {
				freqRace[3]++;
			} else {
				freqRace[4]++;
			}

		}
		for (int i = 0; i < freqRace.length; i++) {
			report += typeNames[i] + " : " + freqRace[i] + "\n";
		}

		return report;

	}

	/**
	 * This method returns the frequency of each score
	 * 
	 * @return frequency of each score
	 */
	public String freqReport() {
		String report = "Frequency of Scores is \n";
		int[] total = new int[5];
		for (int i = 0; i < compList.size(); i++) {

			total = sum(total, compList.get(i).getScoreFrequency());

		}
		for (int i = 0; i < total.length; i++) {
			report += "Score " + (i + 1) + " : " + total[i] + "\n";
		}

		return report;
	}
	
	public int numberCompetitors() {

		return compList.size();
	}

	/**
	 * This method returns the name of competitor with highest overall score and his
	 * score
	 * 
	 * @return competitor with highest score
	 */
	public String highestScore() {

		double max = compList.get(0).getOverallScore();
		int index = 0;
		for (int i = 1; i < compList.size(); i++) {
			if (max < compList.get(i).getOverallScore()) {
				max = compList.get(i).getOverallScore();
				index = i;
			}
		}
		return "There competitor with the highest score is " + compList.get(index).getCompName() + " with a score of "
				+ max;
	}

	/**
	 * This method returns the name of competitor with lowest overall score and his
	 * score
	 * 
	 * @return competitor with lowest score
	 */
	public String lowestScore() {
		double min = compList.get(0).getOverallScore();
		int index = 0;
		for (int i = 1; i < compList.size(); i++) {
			if (min > compList.get(i).getOverallScore()) {
				min = compList.get(i).getOverallScore();
				index = i;
			}
		}

		return "There competitor with the lowest score is " + compList.get(index).getCompName() + " with a score of "
				+ min;

	}

	/**
	 * This method returns the average overall score of all competitors
	 * 
	 * @return average overall score
	 */
	public String averageScore() {
		double sum = compList.get(0).getOverallScore();
		for (int i = 1; i < compList.size(); i++) {

			sum += compList.get(i).getOverallScore();

		}

		return "The average Overall Score of the competitors is " + sum / compList.size();
	}
	public int[] sum(int[] a, int[] b) {
		int[] sum = new int[5];
		for (int i = 0; i < 5; i++) {
			sum[i] = a[i] + b[i];

		}

		return sum;
	}
	
	public String getCompDetails(int no) {
		for (int i = 0; i < compList.size(); i++) {
			if (no == compList.get(i).getCompNum()) {
				return compList.get(i).getFullDetails();
			}

		}

		return "Competitor not found";
	}
  private void search() {
    	//get search text and search staff list
    	//setting result text 
        String searchString = searchField.getText().trim();
        String res;
        if(searchString.length() > 0) {
        	res=getCompDetails(Integer.parseInt(searchString));
        	result.setText(res);
    }
  }
}
