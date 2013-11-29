import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

public class MainClass extends JApplet implements ActionListener
 {
	JPanel mainPanel;
	JPanel changePanel;
	JPanel tempPanel;
	List<JPanel>  panelList  = new ArrayList  <JPanel>  ();
	
	JButton mybutton;
	JLabel mylabel;	

	
	JRadioButton radio1;
	JRadioButton radio2;

public void createTitle(String title)
	{
		tempPanel = new JPanel();
		tempPanel.setBackground( Color.white );
		
		tempPanel.add( new JLabel(title));
		
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
		panelList.add( tempPanel );
	}
	
	public void createQuestionPanel(String question, String answer1, String answer2, String answer3)
	{
		tempPanel = new JPanel();
		//tempPanel.setBackground( Color.orange );
		
		tempPanel.add( new JLabel(question) );
		tempPanel.add( new JRadioButton( answer1));
		tempPanel.add( new JRadioButton( answer2));
		tempPanel.add( new JRadioButton( answer3));
		
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
		panelList.add( tempPanel );
	}
	
	public void createButton(String name)
	{
		tempPanel = new JPanel();
		tempPanel.add( new JButton(name) );
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
		panelList.add( tempPanel );
	}
	
	public void printPanels()
	{
		Iterator < JPanel >    panelIT =  panelList.iterator();			
        while ( panelIT.hasNext() )
        {
        	JPanel currPanel = panelIT.next();
        	mainPanel.add ( currPanel );
        }
		
		this.add( mainPanel );
	}
	
	public void init()
	{
		
		this.setSize( 500, 500 );
		
		JPanel topPanel = new JPanel();
			topPanel.setBackground( Color.WHITE );
			topPanel.setSize( 500, 400 );
		
		JPanel bottomPanel = new JPanel();
		
			bottomPanel.setSize( 500, 100 );
			bottomPanel.setLocation(0, 400);
			bottomPanel.add( new JLabel ("i'm on the bottom, you know?") );
			bottomPanel.setBackground( Color.lightGray );
		
/*			MAIN FOR HOMEWERK
			createTitle("Sample C Driver Written Test");
			
			createQuestionPanel("1. blah", "1", "2", "3");
			createQuestionPanel("1. blah", "1", "2", "3");
			createQuestionPanel("1. blah", "1", "2", "3");
			createButton("Submit");
			
			printPanels();
*/



		// create main panel
			mainPanel = new JPanel();
			mainPanel.setSize( 500, 500 );
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));	// BOX LAYOUT
			mainPanel.setBackground( Color.gray );
			
		// add a button
			mybutton = new JButton("OK");
			mybutton.addActionListener(this);
			topPanel.add(mybutton);
		
		// add a label
			mylabel = new JLabel("some label");
			topPanel.add(mylabel);
			//mainPanel.addHorizontalLine();
		
			
		
		// add radio buttons	
		JPanel radioPanel = new JPanel();
			radio1 = new JRadioButton("This option?");
			radio1.setMnemonic(KeyEvent.VK_B);
			radio1.setActionCommand("This option?");
			radio1.setSelected(true);
		
		
			radio2 = new JRadioButton("Maybe This?");
			radio2.setMnemonic(KeyEvent.VK_C);
			radio2.setActionCommand("Maybe This?");
			
			ButtonGroup group = new ButtonGroup();
			group.add(radio1);
			group.add(radio2);
		
			radio1.addActionListener(this);
			radio2.addActionListener(this);
		
		radioPanel.add(radio1);
		radioPanel.add(radio2);
		
		panelList.add( radioPanel );
	
		// add changePanel
			tempPanel = new JPanel();
			tempPanel.setBackground( Color.green );
			tempPanel.setName("green panel");
			tempPanel.add( new JLabel("MOTHERFUCKING LABEL") );
			
			
			panelList.add( tempPanel );
			
		// add two random panels
			tempPanel = new JPanel();
			tempPanel.setBackground( Color.orange );
			tempPanel.add( new JLabel("MOTHERFUCKING LABEL 1") );
			
			
			panelList.add( tempPanel );
			
			
			tempPanel = new JPanel();
			tempPanel.setName("red panel");
			
			tempPanel.setBackground( Color.red );
			tempPanel.add( new JLabel("MOTHERFUCKING LABEL 2") );
			
			panelList.add( tempPanel );
			
		// add random panels to main panel
			Iterator < JPanel >    panelIT =  panelList.iterator();
	        
	        while ( panelIT.hasNext() )
	        {
	        	JPanel currPanel = panelIT.next();
	        	
	        	topPanel.add ( currPanel );
	        }
		
		//topPanel.add( changePanel );		
		
		mainPanel.add( topPanel );
		mainPanel.add( bottomPanel );
		
		this.add( mainPanel );
		
		}
		

		@Override
		public void actionPerformed(ActionEvent event)
		{
				if (event.getSource() == mybutton && mylabel.getText() != "My button was clicked")
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
			
		}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
