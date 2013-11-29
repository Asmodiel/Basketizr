import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
	List<JPanel>  panelList  = new ArrayList  <JPanel>  ();
	
	int score;
	static final int PANELS = 3; 	 	
	int [] correct = new int [PANELS]; 	 	
	ButtonGroup [] allgroups = new ButtonGroup [PANELS];	
	
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
	
	public void createQuestionPanel(int in, String question, String id, String [] answers)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.setName( id );
		//tempPanel.setBackground( Color.orange );
	
		tempPanel.add( new JLabel(question) );
		for(int i=0;i<answers.length;i++)
		{
			JRadioButton temp = new JRadioButton(answers[i]);
			allgroups[in].add(temp);
			tempPanel.add(temp);
		}
		
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		panelList.add( tempPanel );
	}
	
	public void createButton(String name)
	{
		tempPanel = new JPanel();
		tempButton = new JButton(name);
		
		tempButton.addActionListener(this);
		
		tempPanel.add( tempButton );
		
		panelList.add( tempPanel );
	}
	
	
	public void printPanels()
	{
		Iterator < JPanel >    panelIT =  panelList.iterator();			
        while ( panelIT.hasNext() )
        {
        	JPanel currPanel = panelIT.next();
        	contentPanel.add ( currPanel );
        }
		
		this.add( contentPanel );
				
	}
	
	public void init()
	{
		score = 0;
		this.setSize( 500, 600 );
		
		// create main panel
		mainPanel = new JPanel( );
		mainPanel.setSize( 500, 500 );
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));	// BOX LAYOUT
		mainPanel.setBackground( Color.gray );		
		
		contentPanel = new JPanel();
			contentPanel.setBackground( Color.WHITE );
			contentPanel.setLayout( new BoxLayout( contentPanel, BoxLayout.Y_AXIS ) );
			contentPanel.setPreferredSize( new Dimension( 500, 500 ) );
		
		bottomPanel = new JPanel();
		
			bottomPanel.setPreferredSize( new Dimension( 500, 50 ) );
			bottomPanel.add( new JLabel ("i'm on the bottom, you know?") );
			bottomPanel.setBackground( Color.lightGray );
			
			tempLabel = new JLabel(" status ");
			bottomPanel.add( tempLabel );
			
		
			//MAIN FOR HOMEWERK
			createTitle("Sample C Driver Written Test");
			String[] questions = new String [PANELS];
			questions[0]="1. You may drive off of the paved roadway to pass another vehicle:";
			questions[1]="2. What is the meaning of this sign?";
			questions[2]="3. What is the meaning of this sign?";
			
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
				createQuestionPanel(i,questions[i],"q"+i,answers[i]);
			}			
			createButton("Submit");
			printPanels();
			

		
			mainPanel.add( contentPanel, BorderLayout.CENTER );
			mainPanel.add( bottomPanel, BorderLayout.PAGE_END );
		
		this.add( mainPanel );
		
		}
		

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == tempButton )
			{	
				if(score < 2 )
					tempLabel.setText("Your score is: " + score + ". You failed, bitch!");
				else
					tempLabel.setText("Your score is: " + score + ". You passed, bitch!");
			}
			

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
