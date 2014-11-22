import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Profile extends JFrame implements ActionListener,ItemListener 
{
	public static JPanel p;
	private JLabel name,id,email,ph,pswd,pskey,balance,accno;
	private JTextField tfname,tfid,tfemail,tfph,tfpswd,tfpskey,tfbalance,tfaccno;
	private JCheckBox cbpswd,cbpskey;
	private JButton update;
	
	public Profile()
	{
		setComponents();
		addComponents();
		p.setBackground(new Color(255,153,0));
		setValues();
	}
	
	public void setComponents()
	{
		p=new JPanel();
		name=new JLabel("Name: ");
		id=new JLabel("Id no: ");
		email=new JLabel("Email: ");
		ph=new JLabel("Phone: ");
		pswd=new JLabel("Password");
		pskey=new JLabel("Transaction Key: ");
		balance=new JLabel("Balance: ");
		accno=new JLabel("Account Number: ");
		
		update=new JButton("Update");
		
		cbpswd=new JCheckBox("Change");
		cbpskey=new JCheckBox("Change");
		
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
		p.setLayout(null);
		name.setBounds(10,10,100,30);tfname.setBounds(110,10,200,30);
		id.setBounds(10,50,100,30);tfid.setBounds(110,50,200,30);
		email.setBounds(10,90,100,30);tfemail.setBounds(110,90,200,30);
		ph.setBounds(10,130,100,30);tfph.setBounds(110,130,200,30);
		pswd.setBounds(10,170,100,30);tfpswd.setBounds(110,170,200,30);cbpswd.setBounds(320,170,70,30);
		pskey.setBounds(10,210,100,30);tfpskey.setBounds(110,210,200,30);cbpskey.setBounds(320,210,70,30);
		balance.setBounds(10,250,100,30);tfbalance.setBounds(110,250,200,30);
		update.setBounds(130,300,100,30);
		//tfaccno
		p.add(name);p.add(tfname);
		p.add(id);p.add(tfid);
		p.add(email);p.add(tfemail);
		p.add(ph);p.add(tfph);
		p.add(pswd);p.add(tfpswd);p.add(cbpswd);
		p.add(pskey);p.add(tfpskey);p.add(cbpskey);
		p.add(balance);p.add(tfbalance);
		p.add(update);
		p.setBounds(200,150,500,400);
		
		p.setBackground(new Color(255,153,0));
		tfname.setEditable(false);
		tfid.setEditable(false);
		tfemail.setEditable(false);
		tfph.setEditable(false);
		tfpswd.setEditable(false);
		tfpskey.setEditable(false);
		tfbalance.setEditable(false);
		tfaccno.setEditable(false);
		cbpswd.addItemListener(this);
		cbpskey.addItemListener(this);
		update.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==update)
		{
			if(tfpswd.isEditable() || tfpskey.isEditable())
			{
				//call DB
				//update pskey or pswd
				try{
					String query="UPDATE profiles SET pswd='"+tfpswd.getText()+"', pskey='"+tfpskey.getText()+"' WHERE id='"+tfid.getText()+"'";
					ConnectToDB.connect(query);
					query="UPDATE users SET pswd='"+tfpswd.getText()+"' WHERE id='"+tfid.getText()+"'";
					ConnectToDB.connect(query);
					ConnectToDB.con.commit();
					ConnectToDB.con.close();
					Authenticate.auth(tfid.getText(), tfpswd.getText().toCharArray(), 0);
					//send email
					setValues();
					p.repaint();
					System.out.println("Updated");
				}catch(Exception e){System.out.println(e);}
			}
		}
	}
	
	public void setValues()
	{
		
		String[] s=User.details.split("\t");
		Authenticate.auth(s[0],s[4].toCharArray(),1);
		tfid.setText(s[0]);
		tfname.setText(s[1]);
		tfemail.setText(s[2]);
		tfph.setText(s[3]);
		tfpswd.setText(s[4]);
		tfpskey.setText(s[5]);
		tfbalance.setText(s[6]);
		tfaccno.setText(s[7]);
		cbpskey.setSelected(false);
		cbpswd.setSelected(false);
		
	}

	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getSource()==cbpswd)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED){tfpswd.setEditable(true);}
			else{tfpswd.setEditable(false);}
		}
		if(ie.getSource()==cbpskey)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED){tfpskey.setEditable(true);}
			else{tfpskey.setEditable(false);}
		}
		
	}
}
