import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass extends JApplet implements ActionListener {


	JPanel mainPanel;
	JPanel changePanel;
	
	
	JButton mybutton;
	JLabel mylabel;	
	JLabel changeLabel;
	
	public void init()
	{
		mainPanel = new JPanel();
		changePanel = new JPanel();
		
		mybutton = new JButton("OK");
		mybutton.addActionListener(this);
		
		mylabel = new JLabel();
		changeLabel = new JLabel("MOTHERFUCKING LABEL");
			
		mainPanel.add(mybutton);
		mainPanel.add(mylabel);
		mainPanel.setBackground( Color.gray );
		
		changePanel.setBackground( Color.green );
		changePanel.add(changeLabel);
		
		mainPanel.add( changePanel );	
		
		this.add( mainPanel );
		
		
		
		}
		

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == mybutton && mylabel.getText() != "My button was clicked")
			{
				mylabel.setText("My button was clicked");
				mybutton.setText("Ok");
				changePanel.setVisible(false);
			}
			else
			{
				mylabel.setText("");
				mybutton.setText("Not Ok");
				changePanel.setVisible(true);
			}
			
		}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
