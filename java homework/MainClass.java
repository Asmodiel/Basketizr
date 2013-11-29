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
	
	public void createQuestionPanel(String question, String id, String answer1, String answer2, String answer3)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.setName( id );
		tempPanel.setBackground( Color.WHITE );
		
		JRadioButton radio1 =  new JRadioButton( answer1 );
		JRadioButton radio2 =  new JRadioButton( answer2 );
		JRadioButton radio3 =  new JRadioButton( answer3 );
		
		ButtonGroup group = new ButtonGroup();
		group.add( radio1 );
		group.add( radio2 );
		group.add( radio3 );
		
		tempPanel.add( new JLabel(question) );
		tempPanel.add( radio1 );
		tempPanel.add( radio2 );
		tempPanel.add( radio3 );
		
		
		tempPanel.setLayout( new BoxLayout( tempPanel, BoxLayout.Y_AXIS ) );
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
