import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DeleteAccount extends JFrame implements ActionListener 
{
	JLabel by,msg;
	JComboBox jcb;
	JTextField input;
	JButton del;
	JPanel panel;
	
	public DeleteAccount()
	{
		setComponents();
		addComponents();
	}
	
	public void setComponents()
	{

		panel=new JPanel();
		by=new JLabel("Delete by: ");
		String[] options={"Name","Id"};
		jcb=new JComboBox(options);
		input=new JTextField();
		del=new JButton("Delete");
		msg=new JLabel();
		

		panel.setLayout(null);
		
		del.addActionListener(this);
	}
	
	public void addComponents()
	{
		by.setBounds(0, 10, 70, 30);
		jcb.setBounds(80, 10, 100, 30);
		input.setBounds(190, 10, 150, 30);
		del.setBounds(350, 10, 100, 30);
		msg.setBounds(10,100,300,30);
		
		panel.add(by);panel.add(jcb);
		panel.add(input);panel.add(msg);
		panel.add(del);
		
		panel.setBounds(150,70,500,400);
		
		msg.setForeground(Color.RED);
		panel.setBackground(new Color(255,153,0));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==del)
		{
			String query="DELETE FROM users WHERE ";
			String query1="DELETE FROM profiles WHERE ";
			if(jcb.getSelectedIndex()==0)
			{
				query+="name='"+input.getText().trim()+"'";
				query1+="name='"+input.getText().trim()+"'";
			}
			else{
				query+="id='"+input.getText().trim()+"'";
				query1+="id='"+input.getText().trim()+"'";
			}
			System.out.println(query);
			
			try{
				ConnectToDB.connect(query);
				
				ConnectToDB.connect(query1);
				ConnectToDB.con.commit();
				ConnectToDB.con.close();
				msg.setText("User deleted successfully!!");
				panel.repaint();
				//delete the transaction table for the specified user
			
				
			}catch(Exception e){msg.setText("error while deleting!!");System.out.println(e);}
			panel.repaint();
		}
	}
	public static void main(String[] args) 
	{
		new DeleteAccount();
	}
}
