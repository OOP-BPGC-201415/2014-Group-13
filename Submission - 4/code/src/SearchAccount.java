import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SearchAccount extends JFrame implements ActionListener 
{
	JLabel by,error;
	JComboBox jcb;
	JPanel scrollpanel,panel;
	JTextField input;
	JButton search;
	JScrollPane jsp;
	JTable results;
	
	String[] tableHeads;
	Container c;
	
	public SearchAccount()
	{
		
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255,153,0));
		setComponents();
		addComponents();
	}
	
	public void setComponents()
	{
		tableHeads=new String[]{"No.","ID","Name"};
		panel=new JPanel();
		scrollpanel=new JPanel();
		by=new JLabel("Search by: ");
		String[] options={"Name","Id"};
		jcb=new JComboBox(options);
		input=new JTextField();
		search=new JButton("Search");
		jsp=new JScrollPane();
		error=new JLabel();

		panel.setLayout(null);
		
		search.addActionListener(this);
	}
	
	public void addComponents()
	{
		by.setBounds(0, 10, 70, 30);
		jcb.setBounds(80, 10, 100, 30);
		input.setBounds(190, 10, 150, 30);
		search.setBounds(350, 10, 100, 30);
		jsp.setBounds(0, 50,500, 300);
		error.setBounds(50, 200, 200, 30);
		panel.add(by);panel.add(jcb);
		panel.add(input);panel.add(jsp);
		panel.add(search);
		
		panel.setBounds(150,70,500,400);
		c.add(panel);
		panel.setBackground(new Color(255,153,0));
		scrollpanel.setBackground(new Color(255,153,0));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==search)
		{
			panel.remove(jsp);
			c.repaint();
			String query="SELECT id,name FROM users WHERE ";
			if(jcb.getSelectedIndex()==0)
			{
				query+="name like'%"+input.getText().trim()+"%'";
			}
			else{
				query+="id like'%"+input.getText().trim()+"%'";
			}
			System.out.println(query);
			
			try{
				String dbOut="";
				ConnectToDB.connect(query);
				if(ConnectToDB.rs!=null){
				while (ConnectToDB.rs.next()) {
					dbOut+=ConnectToDB.rs.getString("id")+"\t"+ConnectToDB.rs.getString("name")+"\n";
				}}
				ConnectToDB.con.close();
				System.out.println(dbOut);
				if(!dbOut.isEmpty()){
				String[] lines=dbOut.split("\n");
				String[][] values=new String[lines.length][3];
				for(int i=0;i<lines.length;i++)
				{
					lines[i]=(i+1)+"\t"+lines[i];
					values[i]=lines[i].split("\t");
				}
				results=new JTable(values,tableHeads);
				//results.setBounds(10, 100, 500, 500);
				results.setEnabled(false);
				jsp.getViewport().add(results);
				jsp.repaint();
				panel.add(jsp);
				c.repaint();
				}

			}catch(Exception e){System.out.println(e);}
		}
	}
}
