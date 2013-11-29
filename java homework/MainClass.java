import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
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
	
	int currentPanelID = 2;
	
	int score;
	static final int PANELS = 3; 	 	
	int [] temp_correct = new int [PANELS];
	ButtonModel [] correct = new ButtonModel [PANELS];	 	
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
	
		tempPanel.add( new JLabel(question) );
		for(int i=0;i<answers.length;i++)
		{
			JRadioButton temp = new JRadioButton(answers[i]);
			allgroups[in].add(temp);
			tempPanel.add(temp);
			if( temp_correct[ id ] == i ) 
			{ 
				correct[ id ] = temp.getModel( ); 
			}
		}
		
		//tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		panelList.add( tempPanel );
	}
	
	public JButton createButton(String name)
	{
		
		JButton button = new JButton(name);
		
		button.addActionListener(this);
		
		bottomPanel.add( button );
		
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
	
	protected static ImageIcon createImageIcon(String path)
	{
	    URL imgURL = MainClass.class.getResource(path);
		
		return new ImageIcon( imgURL );
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
				temp_correct[i] = i%3;
				allgroups[i] = new ButtonGroup();
				createQuestionPanel(i,questions[i], i, answers[i]);
			}		
			nextButton = createButton("Next");
			prevButton = createButton("Previous");
			submitButton = createButton("Submit");
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
				if(score < 2 )
					tempLabel.setText("Your score is: " + score + ". You failed, bitch!");
				else
					tempLabel.setText("Your score is: " + score + ". You passed, bitch!");
			}
			event.getSource();
			if(event.getSource().getClass()==JButton.class)
			{
				if(((JButton)(event.getSource())).getText()=="Submit")
				{
					score = 0;
					for(int i=0;i<PANELS;i++)
					{
						//JRadioButton [] buttonList = //((Component)allgroups[i]).getChildren()
						if (allgroups[i].getSelection() == correct[i])
						{
							score++;
						}
					}
				}
				String alert = "failed";
				if(score==PANELS)
				{
					alert = "passed";
				}
				infoBox("Your score is " + score, "You " + alert + " the test!");
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
		public static void infoBox(String infoMessage, String location)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}