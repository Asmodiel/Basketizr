import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MainClass extends JApplet implements ActionListener
{
        JPanel mainPanel;
        JPanel titlePanel;
        JPanel contentPanel;
        JPanel bottomPanel;
        
        JButton nextButton;
        JButton prevButton;
        JButton submitButton;
        JButton quitButton;
        
        List<JPanel>  panelList  = new ArrayList  <JPanel>  ();
        
        int currentPanelID = 0;
        
        int score = 0;
        static final int PANELS = 3;                  
        int [] temp_correct = new int [PANELS];
        ButtonModel [] correct = new ButtonModel [PANELS];                  
        ButtonGroup [] allgroups = new ButtonGroup [PANELS];        
        
        JLabel statusLabel;

		public void createTitle(String title)
		{
	        titlePanel = new JPanel();
	        JLabel jlabel = new JLabel(title);
	        
	        Font titleFont = new Font("Cambria",Font.BOLD,20);
	        jlabel.setFont(titleFont);
	        titlePanel.add(jlabel,BorderLayout.PAGE_START);

	        titlePanel.setBackground( Color.LIGHT_GRAY );
	        titlePanel.setPreferredSize( new Dimension( 490, 40 ) );
	        //titlePanel.setLayout( new BoxLayout( titlePanel, BoxLayout.Y_AXIS ) );
	        
	         mainPanel.add( titlePanel );
		}
		        
		public void createQuestionPanel(int in, String question, int id, String [] answers)
		{
	        JPanel  tempPanel = new JPanel();
	                tempPanel.setName( "" + id );
	                tempPanel.setBackground( new Color(0x0080FF) );
	                tempPanel.setAlignmentX( JPanel.CENTER_ALIGNMENT );
	                                
	        JLabel  tempLabel = new JLabel( createImageIcon("/images/img1.jpg") );
	                tempLabel.setAlignmentX( JPanel.CENTER_ALIGNMENT );
	                tempPanel.add( tempLabel );
	                
	                tempPanel.add( new JLabel(question) );
	                        
	        for( int i = 0; i < answers.length; i++ )
	        {
	                JRadioButton temp = new JRadioButton( answers[ i ] );
	                allgroups[ in ].add( temp );
	                tempPanel.add( temp );
	                if( temp_correct[ id ] == i )
	                {
	                        correct[ id ] = temp.getModel( );
	                }
	        }
	        panelList.add( tempPanel );
		}
			
		public JButton createButton(String name)
		{
			
			JButton button = new JButton(name);
					button.addActionListener( this );
			
			bottomPanel.add( button );
			
			return button;
		}
		
			
		public void printPanels()
		{
			Iterator < JPanel > panelIT = panelList.iterator();
			
		    while ( panelIT.hasNext() )
		    {
		    	JPanel  currPanel = panelIT.next();
		        		currPanel.setVisible( false );
		        		contentPanel.add ( currPanel );
		    }
			
			this.add( contentPanel );	
		}
			
		protected static ImageIcon createImageIcon( String path )
		{
		    URL imgURL = MainClass.class.getResource(path);
			
			return new ImageIcon( imgURL );
		}	
		
		public void init()
		{
			/* set up interface */
			this.setSize( 500, 400 );
			mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)/*new BorderLayout()*/);
				mainPanel.setSize( 500, 400 );
				mainPanel.setBackground( Color.blue );
				//mainPanel.setLayout(new GridLayout(3,1));
				
			contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				contentPanel.setBackground( new Color(0x0080FF) );
				contentPanel.setLayout( new BoxLayout( contentPanel, BoxLayout.Y_AXIS ) );
				contentPanel.setPreferredSize( new Dimension( 490, 300 ) );
			
			bottomPanel = new JPanel();	
				bottomPanel.setPreferredSize( new Dimension( 490, 40 ) );
				bottomPanel.setBackground( Color.lightGray );
				//bottomPanel.setLayout( new BoxLayout( bottomPanel, BoxLayout.Y_AXIS ) );
				
			statusLabel = new JLabel(" ");
				bottomPanel.add( statusLabel );
				
			/* set up questions */
				createTitle( "Sample C Driver Written Test" );
				String[] questions = new String [PANELS];
				questions[0]="1. You may drive off of the paved roadway to pass another vehicle:";
				questions[1]="2. What is the meaning of this sign?";
				questions[2]="3. What is the meaning of this sign?";
				
				String[][] answers = new String [PANELS][3];
				answers[0][0] = "if the shoulder is wide enough to accommodate your vehicle";
				answers[0][1] = "if the vehicle ahead of you is turning left";
				answers[0][2] = "under no circumstances";
			
				answers[1][0] = "give way";
				answers[1][1] = "no entry for vehicular traffic";
				answers[1][2] = "give way to traffic on your right";
			
				answers[2][0] = "no motor vehicles";
				answers[2][1] = "no pedestrians";
				answers[2][2] = "no parking";			
			
				for ( int i = 0; i < PANELS; i++)
				{
					temp_correct[ i ] = i%3;
					allgroups[ i ] = new ButtonGroup();
					createQuestionPanel( i, questions[i], i, answers[i]);
				}		
			
			/* set up buttons */
				prevButton = createButton("Previous");
				prevButton.setVisible(false);
				nextButton = createButton("Next");
				submitButton = createButton("Submit");
				quitButton = createButton("Quit");
			
			/* set up panels */
				printPanels();
				
				panelList.get(0).setVisible(true);
				mainPanel.add( contentPanel, BorderLayout.CENTER );
				mainPanel.add( bottomPanel, BorderLayout.PAGE_END );
			
				this.add( mainPanel );
		}
				
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if( event.getSource() == submitButton )
		    {     
				prevButton.setVisible(false);
				nextButton.setVisible(false);
				score = 0;
				
				for ( int i = 0; i < PANELS; i++)
				{
					if ( allgroups[ i ].getSelection() == correct[ i ] )
					{
						score++;
					}
				}    
				String alert = "failed";
				if ( score == PANELS )
				{
					alert = "passed";
				}
				
				statusLabel.setText( "Your score is " + score + ", You " + alert + " the test!");
				submitButton.setVisible( false );
				Iterator < JPanel >    panelIT =  panelList.iterator();			
		        while ( panelIT.hasNext() )
		        {
		        	panelIT.next().setVisible(false);
		        }
				//contentPanel.setPreferredSize( new Dimension( 490, 0 ) );
		        contentPanel.setVisible(false);
				this.setSize(500,95);
		    }
		    
		    if( event.getSource() == nextButton )
		    {
		    	if ( currentPanelID == 2 )
		    	{
		    		prevButton.setVisible(false);
		    		nextButton.setVisible(false);
		    		return;
		    	}
		    		prevButton.setVisible(true);
		            panelList.get(currentPanelID).setVisible(false);
		            panelList.get(++currentPanelID).setVisible(true);
		    }
		    
		    if ( event.getSource() == quitButton )
		    {
		    	close();
		    }
		            
		    if( event.getSource() == prevButton )
		    {
		            panelList.get(currentPanelID % 3).setVisible(false);
		            panelList.get(--currentPanelID % 3).setVisible(true);
		            if ( currentPanelID == 0 )
		            {
		            	prevButton.setVisible(false);
		            	return;
		            }
		    }
		}
					
		void close () 
		{
			setVisible (false);	         
			System.exit(0);
		}
}