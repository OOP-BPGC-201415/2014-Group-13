import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Retailer extends User implements MouseListener, ActionListener 
{
	static JLabel profile,trans,logout,head,name;
	static Container c;
	JPanel top,center;
	static String details;
	JMenuBar mb;
	JMenu m1;
	JMenuItem m11,m14;
	
	public Retailer(String name)
	{
		super("Welcome");
		setComponents();
		addComponents();
		
		Profile prof=new Profile();
		center=Profile.p;
		c.add(center);
		c.repaint();
		this.name.setText(name);
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void setComponents()
	{
		c=getContentPane();
		head=new JLabel("Admins Login Page");
		profile=new JLabel("Profile");
		trans=new JLabel("Transactions");
		logout=new JLabel("Logout");
		name=new JLabel();
		top=new JPanel();
		center=new JPanel();
		mb=new JMenuBar();
		m1=new JMenu("Actions");
		m11=new JMenuItem("Payment");
		m14=new JMenuItem("Recharge");
		
		//profile.setBackground(Color.RED);
		profile.setOpaque(true);
		trans.setOpaque(true);
		logout.setOpaque(true);
		name.setOpaque(true);
		
		profile.setBackground(new Color(208,208,208));
		trans.setBackground(new Color(208,208,208));
		logout.setBackground(new Color(208,208,208));
		name.setBackground(new Color(208,208,208));
		
		
		top.setOpaque(true);
		top.setBackground(new Color(120,120,120));
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		trans.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		
		name.setHorizontalAlignment(SwingConstants.LEFT);

		c.setLayout(null);
		top.setLayout(null);
	}
	
	public void addComponents()
	{
		
		profile.setBounds(10,0,100,50);
		trans.setBounds(120, 0, 100, 50);
		logout.setBounds(230, 0, 100, 50);
		name.setBounds(340,0,200,50);

		top.setBounds(0, 10, 800,50);
		center.setBounds(0,200,800,590);
		
		top.add(profile);
		top.add(trans);
		top.add(logout);top.add(name);
		
		c.add(top);
		c.setBackground(new Color(255,153,0));
		top.setBackground(new Color(255,153,0));
		center.setBackground(new Color(255,153,0));
		this.setJMenuBar(mb);
		m1.add(m11);m1.add(m14);
		mb.add(m1);
		
		m11.addActionListener(this);
		m14.addActionListener(this);
		profile.addMouseListener(this);
		trans.addMouseListener(this);
		logout.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent me) 
	{
		if(me.getSource()==profile)
		{
			//set the below panel to profile contents
			c.remove(center);
			center=new Profile().p;
			c.add(center);
			c.repaint();
		}
		if(me.getSource()==trans)
		{
			c.remove(center);
			center=new Transaction().panel;
			c.add(center);
			c.repaint();
		}
		if(me.getSource()==logout)
		{
			this.dispose();new Login();
		}
	}
	

	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==profile)profile.setBackground(Color.WHITE);
		if(me.getSource()==trans)trans.setBackground(Color.WHITE);
		if(me.getSource()==logout)logout.setBackground(Color.WHITE);
	}

	public void mouseExited(MouseEvent me) 
	{
		if(me.getSource()==profile)profile.setBackground(new Color(208,208,208));
		if(me.getSource()==trans)trans.setBackground(new Color(208,208,208));
		if(me.getSource()==logout)logout.setBackground(new Color(208,208,208));
	}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==m11)
		{
			c.remove(center);
			Payment p=new Payment();
			p.to.setText(this.name.getText()+" Payment Page");
			center=p.panel;
			c.add(center);
			c.repaint();
			//System.out.println("Add account clicked!");
		}if(ae.getSource()==m14)
		{
			new Recharge();
		}
		
	}
	public static void main(String[] args) 
	{
		new Retailer("Admin");
	}
}
