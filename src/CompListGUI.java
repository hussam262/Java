import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CompListGUI extends JFrame  implements ActionListener{
    private ArrayList<HARCompetitor> compList;
    private ArrayList<HARCompetitor> sh;
    private ArrayList<HARCompetitor> m;
    private ArrayList<HARCompetitor> l;
    private ArrayList<HARCompetitor> h;
    private ArrayList<HARCompetitor> o;
    
    //GUI components
    JTextField result;
    JTextField searchField;
    JButton search;
    JScrollPane scrollList;
    JButton shortButton , middleButton, longButton, hurdleButton, otherButton, allButton;
    JTextArea displayList;
    
    public CompListGUI(CompetitorList list)
    {
        this.compList = list.getCompList();
        this.sh=list.getSh();
        this.m=list.getM();
        this.l=list.getL();
        this.h=list.getH();
        this.o=list.getO();
        //set up window title
        setTitle("Competitor List");
        //disable standard close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        getRootPane().setBorder(
           BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));


		setupSouthPanel();
		setupNorthPanel();
		setupCenterPanel();

        //pack and set visible
        pack();
        setSize(480, 500);
        
        setVisible(true);

    }
    
    private void setupCenterPanel() {
        JPanel centerPanel = new JPanel();
        shortButton = new JButton("Short Distance");
        shortButton.addActionListener(this);
        
        middleButton = new JButton("Middle Distance");
        middleButton.addActionListener(this);
        
        longButton = new JButton("Long Distance");
        longButton.addActionListener(this);
        
        hurdleButton = new JButton("Hurdle");
        hurdleButton.addActionListener(this);
        
        otherButton = new JButton("Other");
        otherButton.addActionListener(this);
        
        allButton = new JButton("All Competitors");
        allButton.addActionListener(this);

        centerPanel.setLayout(new GridLayout(3, 2, 15, 15));
        centerPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
        centerPanel.add (shortButton);
        centerPanel.add(middleButton);
        centerPanel.add(longButton);
        centerPanel.add(hurdleButton);
        centerPanel.add(otherButton);
        centerPanel.add(allButton);
        this.add(centerPanel, BorderLayout.CENTER);

    }
    
    private void setupSouthPanel() {
        //search panel contains label, text field and button
        /*JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,3));
        searchPanel.add(new JLabel("Enter ID"));   
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
        this.add(southPanel, BorderLayout.SOUTH);   	*/
    }
    
    private void setupNorthPanel() {
        
      JPanel northPanel = new JPanel();

      JLabel label = new JLabel("Running Competition");
      label.setFont(new Font("Calibri", Font.BOLD, 20));
      northPanel.add(label);
      northPanel.setSize(200, 30);


        this.add(northPanel, BorderLayout.NORTH);
    }
    
    //come here when button is clicked
    //find which button and act accordingly
    public void actionPerformed(ActionEvent e) 
    { 
    	if (e.getSource() == search) {
    		//search();
    	}
    	else if (e.getSource() == shortButton) {
        	RaceGUI gui = new RaceGUI(sh);
            gui.setVisible(true);
    
    	}
    	else if (e.getSource() == middleButton ) {
        	RaceGUI gui = new RaceGUI(m);
            gui.setVisible(true);

    	}
    	else if (e.getSource() == longButton) {
        	RaceGUI gui = new RaceGUI(l);
            gui.setVisible(true);
    	}
    	else if (e.getSource() == hurdleButton) {
        	RaceGUI gui = new RaceGUI(h);
            gui.setVisible(true);
    	}
    	else if (e.getSource() == otherButton) {
        	RaceGUI gui = new RaceGUI(o);
            gui.setVisible(true);
    	}
    	else if (e.getSource() == allButton) {
        	RaceGUI gui = new RaceGUI(compList);
            gui.setVisible(true);
    	}
    } 
    
  /*  private void search() {
    	//get search text and search staff list
    	//setting result text 
        String searchString = searchField.getText().trim();
        if(searchString.length() > 0) {
            Staff person = staffList.findById(searchString);
            if (person != null ) {
            	result.setText(person.toString());
            	
            }
            else
            	result.setText("not found");
        }   
        else
        	result.setText("no text entered");
    }*/

}
