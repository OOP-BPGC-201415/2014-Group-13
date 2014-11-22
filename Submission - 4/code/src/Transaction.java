import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame
{
	JPanel panel;
	JTextField input;
	JScrollPane jsp;
	JTable results;
	
	String[] tableHeads;
	Container c;
	public Transaction()
	{
		
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255,153,0));
		setComponents();
		addComponents();
		getTransactions();
		panel.setBackground(new Color(255,153,0));
	}
	
	public void setComponents()
	{
		tableHeads=new String[]{"No.","To ID","From ID","Details","Amount","Time"};
		panel=new JPanel();
		jsp=new JScrollPane();

		panel.setLayout(null);
	}
	
	public void addComponents()
	{
		
		jsp.setBounds(0, 0,500, 300);
		panel.add(jsp);
		
		panel.setBounds(150,100,500,400);
		c.add(panel);
		c.setBackground(new Color(255,153,0));
		panel.setBackground(new Color(255,153,0));
	}
	public void getTransactions()
	{
		try
		{
			String query="SELECT * FROM transactions WHERE toid='"+User.id+"' or fromid='"+User.id+"'";
			System.out.println(User.id);
			String dbOut="";
			ConnectToDB.connect(query);
			while(ConnectToDB.rs.next())
			{
				dbOut+=ConnectToDB.rs.getString("toid")+"\t"+ConnectToDB.rs.getString("fromid")+"\t"+ConnectToDB.rs.getString("Details")+"\t"+ConnectToDB.rs.getString("amount")+"\t"+ConnectToDB.rs.getTimestamp("tym")+"\n";
			}
			
			if(!dbOut.isEmpty())
			{
				String[] lines=dbOut.split("\n");
				String[][] data=new String[lines.length][5];
				for(int i=0;i<lines.length;i++)
				{
					lines[i]=(i+1)+"\t"+lines[i];
					data[i]=lines[i].split("\t");
				}
				
				results=new JTable(data,tableHeads);
				results.setEnabled(false);
				jsp.getViewport().add(results);
				jsp.repaint();
				panel.add(jsp);
				c.repaint();
			}
		}catch(Exception e){System.out.println(e);}
	}
}
