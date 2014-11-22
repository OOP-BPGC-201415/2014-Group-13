import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Recharge 
{
	public Recharge()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		JLabel id = new JLabel("ID: ");
		JLabel amount = new JLabel("Amount: ");
		JTextField tfid=new JTextField();
		JTextField tfamount=new JTextField();
		panel.add(id);panel.add(tfid);
		panel.add(amount);panel.add(tfamount);
		
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, "Confirm Payment",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[1]);
		if(option == 0) // pressing OK button
		{
		    try{ 
		    	String query="SELECT balance FROM profiles WHERE id='"+tfid.getText()+"'";
		    	ConnectToDB.connect(query);
		    	float amt=0;
		    	while(ConnectToDB.rs.next())
		    	{
		    		amt=Float.parseFloat(ConnectToDB.rs.getString("balance"));
		    	}
		    	System.out.println(amt);
		    	
		    	amt+=Float.parseFloat(tfamount.getText());
		    	query="UPDATE profiles SET balance='"+amt+"' WHERE id='"+tfid.getText()+"'";
		    	ConnectToDB.connect(query);
		    	
		    	ConnectToDB.con.commit();
		    	ConnectToDB.con.close();
		    	
		    }catch(Exception e){System.out.println(e.getMessage());}
		}
	}
}
