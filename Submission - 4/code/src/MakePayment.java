
public class MakePayment 
{
	public static boolean pay(char[] pswd,String amount,String id,String details)
	{
		boolean done=false;
		String pskey=new String(pswd);
		try
		{
			String query="SELECT balance,pskey from profiles WHERE id='"+id+"'";
			ConnectToDB.connect(query);
			String dbOut="";
			if(ConnectToDB.rs!=null){
				while (ConnectToDB.rs.next()) {
					dbOut=ConnectToDB.rs.getString("balance")+"\t"+ConnectToDB.rs.getString("pskey");
				}
				String[] words=dbOut.split("\t");
				System.out.println("1");
				if(pskey.equals(words[1]))
				{
					float f= Float.parseFloat(words[0])-Float.parseFloat(amount);
					query="UPDATE profiles SET balance='"+f+"' WHERE id='"+id+"'";
					ConnectToDB.connect(query);
					System.out.println("2");
					query="INSERT INTO transactions VALUES ('"+Retailer.name.getText()+"','"+id+"','"+details+"','"+amount+"',CURRENT_TIMESTAMP)";
					ConnectToDB.connect(query);
					System.out.println("3");
					query="SELECT balance from profiles WHERE id='"+Retailer.name.getText()+"'";
					ConnectToDB.connect(query);
					System.out.println("4");
					String amt="";
					while (ConnectToDB.rs.next()) {
						amt=ConnectToDB.rs.getString("balance");
					}					
					f= Float.parseFloat(amt)+Float.parseFloat(amount);
					query="UPDATE profiles SET balance='"+f+"' WHERE id='"+Retailer.name.getText()+"'";
					ConnectToDB.connect(query);
					System.out.println("5");
					done=true;
				}
				ConnectToDB.con.commit();
				ConnectToDB.con.close(); 
			}
			
		}catch(Exception e){System.out.println(e);}
		return done;
	}
}
