import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener
{
	JPanel panel;
	AddAccount a;
	Container c;
	public Signup() {
		c=getContentPane();
		panel=new JPanel();
		a=new AddAccount();
		panel=a.panel;
		a.add.setText("Signup");
		
		panel.setBounds(200, 50, 500, 400);
		panel.setBackground(new Color(255,153,0));
		a.add.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==a.add)
		{
			if(a.added)this.dispose();
		}
	}
}

