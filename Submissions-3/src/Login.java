import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Login extends JFrame implements ActionListener
{
	private JLabel head,uname,pswd,cat,forgot,background,error;
	private JButton login,clear;
	private JTextField tfuname;
	private JPasswordField tfpswd;
	private JComboBox cbcat;
	private Container c;
	private String[] cats={"Student","Retailer","Admin","Faculty"};
	public Login()
	{
		super("E-Wallet");
		setComponents();
		addComponents();
		
		setSize(800,600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void setComponents()
	{
		head=new JLabel("Login page");
		uname=new JLabel("Username: ");
		pswd=new JLabel("Password: ");
		cat=new JLabel("Login as: ");
		forgot=new JLabel("forgot password!?");
		error=new JLabel("error");
		login=new JButton("Login");
		clear=new JButton("Clear fields");
		
		tfuname=new JTextField();
		tfpswd=new JPasswordField();
		
		cbcat=new JComboBox(cats);
		c=getContentPane();		
		
		//setting fonts for all the components
		
		Font f=new Font("Segoe", Font.PLAIN, 20);
		Font f2=new Font("Verdana", Font.PLAIN, 15);
		
		head.setFont(f);
		
		uname.setFont(f);
		pswd.setFont(f);
		cat.setFont(f);
		forgot.setFont(new Font("Arial", Font.PLAIN, 10));
		
		tfuname.setFont(f2);
		tfpswd.setFont(f2);
		error.setForeground(Color.RED);
		
		forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public void addComponents()
	{
		c.setLayout(null);

		head.setBounds(325,80,200,30);
		
		uname.setBounds(250,150,110,30);
		tfuname.setBounds(360,150,150,30);
		
		pswd.setBounds(250,200,110,30);
		tfpswd.setBounds(360,200,150,30);
		
		cat.setBounds(250,250,110,30);
		cbcat.setBounds(360,250,150,30);
		
		login.setBounds(250,300,110,30);
		clear.setBounds(380,300,110,30);
		
		forgot.setBounds(280,340,100,15);
		
		error.setBounds(320,350,150,30);
		
		c.add(head);c.add(uname);c.add(tfuname);
		c.add(pswd);c.add(tfpswd);c.add(cat);
		c.add(cbcat);c.add(forgot);c.add(login);
		c.add(clear);
		//c.add(error);
		
		//adding action triggers
		login.addActionListener(this);
		clear.addActionListener(this);
		forgot.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {forgot.setText("forgot password!?");}
			
			public void mouseEntered(MouseEvent arg0) {forgot.setText("<html><u>forgot password</u>!?</html>");}
			
			public void mouseClicked(MouseEvent me) 
			{				
				new ForgotPassword();				
			} 
		});
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			if(tfuname.getText().isEmpty() || tfpswd.getPassword().toString().isEmpty()){error.setText("Please enter Username/Password");}
			else
			{
				if(cbcat.getSelectedIndex()==0)
				{
					if(!Authenticate.auth(tfuname.getText(),tfpswd.getPassword(),0))
					{
						error.setText("Username/Password is wrong!!");c.add(error);c.repaint();
					}
					else {new Student(tfuname.getText()); this.dispose();}
				}
			}
		}
		if(ae.getSource()==clear)
		{
			tfpswd.setText("");
			tfuname.setText("");
			cbcat.setSelectedIndex(0);
		}
	}
	
	public static void main(String[] args) 
	{
		new Login();
	}
}
