import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MainClass extends JApplet implements ActionListener
 {
	//test
	JPanel mainPanel;
	JPanel contentPanel;
	JPanel bottomPanel;
	
	JButton nextButton;
	JButton prevButton;
	JButton submitButton;
	
	List<JPanel>  panelList  = new ArrayList  <JPanel>  ();
	
<<<<<<< HEAD
	int currentPanelID = 2;
	
	int score;
	static final int PANELS = 3; 	 	
	int [] correct = new int [PANELS]; 	 	
	ButtonGroup [] allgroups = new ButtonGroup [PANELS];	
=======
>>>>>>> 468fd2c33f462a34d77e7ab55cf1f707b9bb29a5
	
	JButton tempButton;
	JLabel tempLabel;
	JPanel tempPanel;
	
	JRadioButton correctRadio;
	JRadioButton wrongRadio;

public void createTitle(String title)
	{
		JPanel titlePanel = new JPanel();
		titlePanel.setName("title");
		titlePanel.setBackground( Color.orange );
		titlePanel.setPreferredSize( new Dimension( 500, 50 ) );
		
		titlePanel.add( new JLabel(title), BorderLayout.PAGE_START );
		
		
		mainPanel.add( titlePanel );
	}
	
<<<<<<< HEAD
	public void createQuestionPanel(int in, String question, int id, String [] answers)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.setBackground( Color.green );
		tempPanel.setAlignmentX( JPanel.CENTER_ALIGNMENT );
		tempPanel.setName( "" + id );
	
		ImageIcon img = createImageIcon("/images/img1.jpg");
		JLabel tempLabel = new JLabel(img);
		
		tempLabel.setAlignmentX( JPanel.CENTER_ALIGNMENT );
		tempPanel.add( tempLabel );
	
=======
	public void createQuestionPanel(String question, String id, String answer1, String answer2, String answer3)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.setName( id );
		ButtonGroup group = new ButtonGroup();
		//tempPanel.setBackground( Color.orange );
		
		JRadioButton radio1 =  new JRadioButton( answer1 );
		JRadioButton radio2 =  new JRadioButton( answer2 );
		JRadioButton radio3 =  new JRadioButton( answer3 );
		
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		
>>>>>>> 468fd2c33f462a34d77e7ab55cf1f707b9bb29a5
		tempPanel.add( new JLabel(question) );
		tempPanel.add( radio1 );
		tempPanel.add( radio2 );
		tempPanel.add( radio3 );
		
		
		//tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		panelList.add( tempPanel );
	}
	
	public JButton createButton(String name)
	{
<<<<<<< HEAD
		
		JButton button = new JButton(name);
		
		button.addActionListener(this);
		
		bottomPanel.add( button );
		
=======
		tempPanel = new JPanel();
		JButton button = new JButton(name);
		
		button.addActionListener(this);
		
		tempPanel.add( button );
		
		bottomPanel.add( tempPanel );
>>>>>>> 468fd2c33f462a34d77e7ab55cf1f707b9bb29a5
		return button;
	}
	
	
	public void printPanels()
	{
		Iterator < JPanel >    panelIT =  panelList.iterator();			
        while ( panelIT.hasNext() )
        {
        	JPanel  currPanel = panelIT.next();
	        		currPanel.setVisible(false);
	        		contentPanel.add ( currPanel );
        }
		
		this.add( contentPanel );
				
	}
	
	public void init()
	{
		
		this.setSize( 500, 700 );

		// create main panel
		mainPanel = new JPanel( new CardLayout() );
		mainPanel.setSize( 500, 500 );
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));	// BOX LAYOUT
		mainPanel.setBackground( Color.gray );		
		
		contentPanel = new JPanel();
			contentPanel.setBackground( Color.WHITE );
			contentPanel.setSize( 500, 400 );
		
		bottomPanel = new JPanel();
		
<<<<<<< HEAD
			bottomPanel.setPreferredSize( new Dimension( 500, 50 ) );
=======
			bottomPanel.setSize( 500, 100 );
			bottomPanel.setLocation(0, 400);
			bottomPanel.add( new JLabel ("i'm on the bottom, you know?") );
>>>>>>> 468fd2c33f462a34d77e7ab55cf1f707b9bb29a5
			bottomPanel.setBackground( Color.lightGray );
			
			tempLabel = new JLabel(" status ");
			bottomPanel.add( tempLabel );
			
		
			//MAIN FOR HOMEWERK
			createTitle("Sample C Driver Written Test");
			
<<<<<<< HEAD
			String[][] answers = new String [PANELS][3];
			answers[0][0] = "if the vehicle ahead of you is turning left";
			answers[0][1] = "if the vehicle ahead of you is turning right";
			answers[0][2] = "under no circumstances";

			answers[1][0] = "give way";
			answers[1][1] = "no entry for vehicular traffic";
			answers[1][2] = "give way to traffic on your right";

			answers[2][0] = "no motor vehicles";
			answers[2][1] = "no pedestrians";
			answers[2][2] = "no parking";			

			for(int i=0;i<PANELS;i++)
			{
				correct[i] = i%3;
				allgroups[i] = new ButtonGroup();
				createQuestionPanel(i,questions[i], i, answers[i]);
			}		
			nextButton = createButton("Next");
			prevButton = createButton("Previous");
			submitButton = createButton("Submit");
=======
			createQuestionPanel
			(
				"1. You may drive off of the paved roadway to pass another vehicle:"
				, "q1"
				, "if the vehicle ahead of you is turning left"
				, "if the vehicle ahead of you is turning left"
				, "under no circumstances"
			);
			createQuestionPanel
			(
				"2. What is the meaning of this sign?"
				, "q2"
				, "give way"
				, "no entry for vehicular traffic"
				, "give way to traffic on your right"
			);
			createQuestionPanel
			(
				"3. What is the meaning of this sign?"
				, "q3"
				, "no motor vehicles"
				, "no pedestrians"
				, "no parking"
			);
			createButton("Submit");
>>>>>>> 468fd2c33f462a34d77e7ab55cf1f707b9bb29a5
			printPanels();
			panelList.get(0).setVisible(true);
			

		
			mainPanel.add( contentPanel, BorderLayout.CENTER );
			mainPanel.add( bottomPanel, BorderLayout.PAGE_END );
		
		this.add( mainPanel );
		
		}
		

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == tempButton )
			{		
				tempLabel.setText("My button was clicked");
			}
			event.getSource();
			

/*				if (event.getSource() == mybutton && mylabel.getText() != "My button was clicked")
//>>>>>>> Button action
			{
				mylabel.setText("My button was clicked");
				mybutton.setText("Ok");
				//changePanel.setVisible(false);\
				Iterator < JPanel >    panelIT =  panelList.iterator();
		        
		        while ( panelIT.hasNext() )
		        {
		        	JPanel currPanel = panelIT.next();
		        	
		        	if ( currPanel.getName() == "red panel" )
		        	{
		        		
		        		currPanel.setVisible ( false );
		        		
		        	}
		        }
				return;
			}
		
			if (event.getSource() == mybutton && mylabel.getText() == "My button was clicked")
			{
				mylabel.setText("");
				mybutton.setText("Not Ok");
				Iterator < JPanel >    panelIT =  panelList.iterator();
		        
		        while ( panelIT.hasNext() )
		        {
		        	JPanel currPanel = panelIT.next();
		        	
		        	if ( currPanel.getName() == "red panel" )
		        	{
		        		
		        		currPanel.setVisible ( true );
		        		
		        	}
		        }
				return;
			}
		
			if (event.getSource() == radio1)
			{
				mylabel.setText("My radio1button was clicked");
				return;
			}
		
			if (event.getSource() == radio2)
			{
				mylabel.setText("My radio2button was clicked");
				return;
			}
*/
			
		}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
