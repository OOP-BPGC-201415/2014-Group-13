import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchAccount extends JFrame 
{
	JLabel by;
	JComboBox jcb;
	JPanel panel,scrollpanel;
	JTextField input;
	JButton search;
	JScrollPane jsp;
	JTable results;
	public SearchAccount()
	{
		setComponents();
		addComponents();
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setComponents()
	{
		panel=new JPanel();
		scrollpanel=new JPanel();
		by=new JLabel("Search by: ");
		String[] options={"Name","Id"};
		jcb=new JComboBox(options);
		input=new JTextField();
		search=new JButton("Search");
		jsp=new JScrollPane();
		results=new JTable();
	}
	
	public void addComponents()
	{
		
	}
	public static void main(String[] args) 
	{
		new SearchAccount();
	}
}
