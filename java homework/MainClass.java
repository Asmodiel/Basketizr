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
	//test
	JPanel mainPanel;
	JPanel contentPanel;
	JPanel bottomPanel;
	List<JPanel>  panelList  = new ArrayList  <JPanel>  ();
	
	JButton mybutton;
	JLabel mylabel;	

	
	JRadioButton radio1;
	JRadioButton radio2;

public void createTitle(String title)
	{
		JPanel titlePanel = new JPanel();
		titlePanel.setName("title");
		titlePanel.setBackground( Color.orange );
		titlePanel.setSize( 50, 50 );
		
		titlePanel.add( new JLabel(title));
		
		
		mainPanel.add( titlePanel );
	}
	
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
		
		tempPanel.add( new JLabel(question) );
		tempPanel.add( radio1 );
		tempPanel.add( radio2 );
		tempPanel.add( radio3 );
		
		
		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
		panelList.add( tempPanel );
	}
	
	public void createButton(String name)
	{
		JPanel tempPanel = new JPanel();
		tempPanel.add( new JButton(name) );
		
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
		
		this.setSize( 500, 500 );

		// create main panel
		mainPanel = new JPanel();
		mainPanel.setSize( 500, 500 );
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));	// BOX LAYOUT
		mainPanel.setBackground( Color.gray );		
		
		contentPanel = new JPanel();
			contentPanel.setBackground( Color.WHITE );
			contentPanel.setSize( 500, 400 );
		
		JPanel bottomPanel = new JPanel();
		
			bottomPanel.setSize( 500, 100 );
			bottomPanel.setLocation(0, 400);
			bottomPanel.add( new JLabel ("i'm on the bottom, you know?") );
			bottomPanel.setBackground( Color.lightGray );
			
		mainPanel.add( contentPanel );
		mainPanel.add( bottomPanel );
		
			
		
			//MAIN FOR HOMEWERK
			createTitle("Sample C Driver Written Test");
			
			createQuestionPanel("1. blah", "q1", "1", "2", "3");
			createQuestionPanel("1. blah", "q2", "1", "2", "3");
			createQuestionPanel("1. blah", "q2", "1", "2", "3");
			createButton("Submit");
			printPanels();
			

		
		mainPanel.add( contentPanel );
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
