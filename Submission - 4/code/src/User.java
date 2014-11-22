import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class User extends JFrame
{
	static String name,id,phone,email,accountNumber,passkey,balance,pswd;
	static String details;
	JLabel back=new JLabel();
	public User()
	{
		/*
		 * ConnectToDB.rs.getString("id")+"\t"+ConnectToDB.rs.getString("name")
						+"\t"+ConnectToDB.rs.getString("email")+ConnectToDB.rs.getString("phone")+"\t"
						+"\t"+ConnectToDB.rs.getString("pswd")+"\t"+ConnectToDB.rs.getString("pskey")
						+"\t"+ConnectToDB.rs.getString("balance")+"\t"+ConnectToDB.rs.getString("account")+"\t";
		 */
		String[] words=details.split("\t");
		id=words[0];
		name=words[1];
		email=words[2];
		phone=words[3];
		pswd=words[4];
		passkey=words[5];
		balance=words[6];
		accountNumber=words[7];
		
		back.setBackground(new Color(255,153,0));
	}
	public User(String title)
	{
		super(title);
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getPasskey() {
		return passkey;
	}
}
