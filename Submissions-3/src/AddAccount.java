import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddAccount extends JFrame
{
	JLabel name,id,ph,email,accno,pskey,balance,pswd;
	JTextField tfname,tfid,tfph,tfemail,tfaccno,tfpskey,tfbalance,tfpswd;
	JPanel panel;
	JButton add;
	Container c=getContentPane();
	
	public AddAccount()
	{
		setComponents();
		addComponents();
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setComponents()
	{
		panel=new JPanel();
		name=new JLabel("Name: ");
		id=new JLabel("Id no: ");
		email=new JLabel("Email: ");
		ph=new JLabel("Phone: ");
		pswd=new JLabel("Password");
		pskey=new JLabel("Transaction Key: ");
		balance=new JLabel("Balance: ");
		accno=new JLabel("Acc Number: ");
		
		add=new JButton("Add");
		
		tfname=new JTextField();
		tfid=new JTextField();
		tfemail=new JTextField();
		tfph=new JTextField();
		tfpswd=new JTextField();
		tfpskey=new JTextField();
		tfbalance=new JTextField();
		tfaccno=new JTextField();
		
	}
	
	public void addComponents()
	{
		panel.setLayout(null);
		name.setBounds(10,10,100,30);tfname.setBounds(110,10,200,30);
		id.setBounds(10,50,100,30);tfid.setBounds(110,50,200,30);
		email.setBounds(10,90,100,30);tfemail.setBounds(110,90,200,30);
		ph.setBounds(10,130,100,30);tfph.setBounds(110,130,200,30);
		pswd.setBounds(10,170,100,30);tfpswd.setBounds(110,170,200,30);
		pskey.setBounds(10,210,100,30);tfpskey.setBounds(110,210,200,30);
		balance.setBounds(10,250,100,30);tfbalance.setBounds(110,250,200,30);
		accno.setBounds(10, 290, 100, 30);tfaccno.setBounds(110, 290, 200, 30);
		add.setBounds(130,340,100,30);
		
		panel.add(name);panel.add(tfname);
		panel.add(id);panel.add(tfid);
		panel.add(email);panel.add(tfemail);
		panel.add(ph);panel.add(tfph);
		panel.add(pswd);panel.add(tfpswd);
		panel.add(pskey);panel.add(tfpskey);
		panel.add(balance);panel.add(tfbalance);
		panel.add(accno);panel.add(tfaccno);
		panel.setBounds(200,150,500,400);
		panel.add(add);
		
		c.add(panel);
	}
	public static void main(String[] args) {
		new AddAccount();
	}
}
