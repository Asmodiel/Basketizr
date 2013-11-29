import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass extends JApplet implements ActionListener
 {
	JPanel mainPanel;
	JPanel changePanel;
	
	
	JButton mybutton;
	JLabel mylabel;	
	JLabel changeLabel;

	
	JRadioButton radio1;
	JRadioButton radio2;
	
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
	
		mainPanel.add(radio1);
		mainPanel.add(radio2);
		
		}
		

		@Override
		public void actionPerformed(ActionEvent event)
		{
				if (event.getSource() == mybutton && mylabel.getText() != "My button was clicked")
			{
				mylabel.setText("My button was clicked");
				mybutton.setText("Ok");
				changePanel.setVisible(false);
				return;
			}
		
			if (event.getSource() == mybutton && mylabel.getText() == "My button was clicked")
			{
				mylabel.setText("");
				mybutton.setText("Not Ok");
				changePanel.setVisible(true);
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
