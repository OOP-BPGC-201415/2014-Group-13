import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener {
	private JLabel usrname, head, error;
	private JTextField tfusrname;
	private JButton bgetpswd;
	private Container c;

	public ForgotPassword() {
		super("Forgot Password");
		this.toFront();
		this.setAlwaysOnTop(true);

		setComponents();
		addComponents();
		setSize(400, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public void setComponents() {
		head = new JLabel("Forgot Password");
		usrname = new JLabel("Username: ");
		error = new JLabel();
		tfusrname = new JTextField();
		bgetpswd = new JButton("Reset");

		c = getContentPane();

		bgetpswd.addActionListener(this);

		error.setForeground(Color.RED);
	}

	public void addComponents() {
		c.setLayout(null);

		head.setBounds(130, 20, 150, 30);

		usrname.setBounds(80, 80, 70, 30);
		tfusrname.setBounds(160, 80, 150, 30);

		bgetpswd.setBounds(130, 130, 100, 30);

		error.setBounds(100, 180, 150, 30);

		c.add(head);
		c.add(usrname);
		c.add(tfusrname);
		c.add(bgetpswd);
		c.add(error);

	}

	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == bgetpswd) 
		{
			String s="",query="";
			if (tfusrname.getText().isEmpty()) 
			{
				error.setText("Please enter a Username");
				c.add(error);
				c.repaint();
			}
			else
			{
				error.setText("");
				c.repaint();
				// check in database n generate new one store in database send email.
				
				query="SELECT * FROM user WHERE id='"+tfusrname.getText()+"'";
				try {
					ConnectToDB.connect(query);
					while(ConnectToDB.rs.next()){s+=ConnectToDB.rs.getString("id");}
					ConnectToDB.con.close();
					if(s.isEmpty()){error.setText("User doesnt exist!");c.repaint();}
					else
					{
						error.setText("Updating...");
						c.repaint();
						//change password
						
						System.out.println("entered else!!");
						String genpswd=Long.toHexString(Double.doubleToLongBits(Math.random()));
						
						
						System.out.println(genpswd);
						
						
						query="SELECT email FROM user WHERE id='"+tfusrname.getText()+"'";
						ConnectToDB.connect(query);
						String email="";
						while (ConnectToDB.rs.next()) {
							email+=ConnectToDB.rs.getString("email");
						}
						
						ConnectToDB.con.close();
						
						System.out.println(email);
						
						query="UPDATE user SET password='"+genpswd+"' WHERE id='"+tfusrname.getText()+"'";
						ConnectToDB.connect(query);
						
						error.setText("Password sent to mail");c.repaint();
						
						String body="Your new password is "+genpswd;//body
						if(SendeMail.sendeMail(email,"Password to your ewallet account ",body)){this.dispose();} //sending email
						ConnectToDB.con.commit();
						ConnectToDB.con.close();
					}
					//commit
				}
				catch(SQLException se){
					new WriteLog(WriteLog.getDate()+"\t"+se.getMessage() +"\n"); //write to log file
					error.setText("Error while connecting to Database.");
					c.repaint();					
				}
				catch (Exception e) {
					new WriteLog(WriteLog.getDate()+"\t"+e.getMessage() +"\n"); //write to log
					//e.printStackTrace();
					
				}
			}
		}
	}
}
