import java.sql.ResultSetMetaData;


public class Authenticate 
{
	static boolean ret=false;
	public static boolean auth(String uname,char[] pswd,int type)
	{
		
		//verify account add to Student.details
		
		String pd=new String(pswd).trim();
		System.out.println(pd);
		String query="SELECT * FROM users WHERE id='"+uname+"' AND pswd='"+pd+"'";
		String s=null;
		String det="";
		try{
			ConnectToDB.connect(query);
			s="";
			/*while(ConnectToDB.rs.next())
			{
				s=ConnectToDB.rs.getString("id")+"\t"+ConnectToDB.rs.getString("name")+"\t"+ConnectToDB.rs.getString("pswd")+"\t"+ConnectToDB.rs.getString("tries");
			}
			ConnectToDB.con.close();*/
				query="SELECT * FROM profiles WHERE id='"+uname+"' AND pswd='"+pd+"'";
				ConnectToDB.connect(query);
				while(ConnectToDB.rs.next())
				{
					s=ConnectToDB.rs.getString("id")+"\t"+ConnectToDB.rs.getString("name")
						+"\t"+ConnectToDB.rs.getString("email")+"\t"+ConnectToDB.rs.getString("phone")
						+"\t"+ConnectToDB.rs.getString("pswd")+"\t"+ConnectToDB.rs.getString("pskey")
						+"\t"+ConnectToDB.rs.getString("balance")+"\t"+ConnectToDB.rs.getString("account")+"\t";
				}
				ConnectToDB.con.close();			
		}catch(Exception e){}
		finally
		{
			if(!s.isEmpty())
			{
				ret=true;
				System.out.println(s);
				User.details=s;
				new User();
			}
		}
		return ret;
	}
}