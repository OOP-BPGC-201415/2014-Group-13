import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Student extends User implements MouseListener, ActionListener 
{
	JLabel profile,trans,logout,head,name;
	static Container c;
	JPanel top,center;
	static String details;
	public Student(String name)
	{
		super("Welcome");
		setComponents();
		addComponents();
		
		center=Profile.p;
		c.add(center);
		c.repaint();
		this.name.setText(name);
		setSize(800, 600);
		setVisible(true);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void setComponents()
	{
		c=getContentPane();
		head=new JLabel("Student Login Page");
		profile=new JLabel("Profile");
		trans=new JLabel("Transactions");
		logout=new JLabel("Logout");
		name=new JLabel();
		top=new JPanel();
		center=new JPanel();
		
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
		center.setBounds(0,200,800,550);
		
		top.add(profile);
		top.add(trans);
		top.add(logout);top.add(name);
		
		c.add(top);
		
		profile.addMouseListener(this);
		trans.addMouseListener(this);
		logout.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent me) 
	{
		if(me.getSource()==profile)
		{
			//set the below panel to profile contents
			center=Profile.p;
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

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) 
	{
		new Student("ranga");
	}
}
