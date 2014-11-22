import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Payment extends JFrame implements ActionListener
{
	JLabel to,from,amount,details,time;
	JTextField tffrom,tfamount,tfdetails;
	JButton confirm;
	
	JPanel panel;
	//Container c;
	public Payment()
	{
		setComponents();
		addComponents();
	}
	
	private void setComponents()
	{
		to=new JLabel("");
		from=new JLabel("From: ");
		amount=new JLabel("Amount: ");
		details=new JLabel("Details: ");
		time=new JLabel("Date/Time:    "+new Date().toString());
		
		tffrom=new JTextField();
		tfamount=new JTextField();
		tfdetails=new JTextField();
		
		confirm=new JButton("Confirm to Payment");
		
		panel=new JPanel();
	}
	private void addComponents()
	{
		panel.setLayout(null);
		
		to.setBounds(10, 10, 300, 30);
		from.setBounds(10, 50, 75, 30);tffrom.setBounds(80, 50, 200, 30);
		details.setBounds(10, 90, 75, 30);tfdetails.setBounds(80, 90, 200, 30);
		time.setBounds(10, 130, 300, 30);
		amount.setBounds(10, 160, 75, 30);tfamount.setBounds(80, 160, 100, 30);
		confirm.setBounds(50, 200, 200, 30);
		
		panel.add(to);
		panel.add(from);panel.add(tffrom);
		panel.add(details);panel.add(tfdetails);
		panel.add(time);
		panel.add(amount);panel.add(tfamount);
		panel.add(confirm);
		
		panel.setBounds(200, 100, 300, 300);
		panel.setBackground(new Color(255,153,0));
		
		confirm.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==confirm)
		{
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Enter your transaction key : ");
			JPasswordField pass = new JPasswordField(10);
			panel.add(label);
			panel.add(pass);
			String[] options = new String[]{"OK", "Cancel"};
			int option = JOptionPane.showOptionDialog(null, panel, "Confirm Payment",
			                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
			                         null, options, options[1]);
			if(option == 0) // pressing OK button
			{
			    if(!MakePayment.pay(pass.getPassword(),tfamount.getText(),tffrom.getText(),tfdetails.getText()))
			    {
			    	JOptionPane.showMessageDialog(null, "Transaction failed!!");
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Transaction successfull!!");
			    	tfamount.setText("");
			    	tfdetails.setText("");
			    	tffrom.setText("");
			    }
			}
		}
	}
}
