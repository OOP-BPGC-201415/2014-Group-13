import java.sql.ResultSetMetaData;


public class Authenticate 
{
	public static boolean auth(String uname,char[] pswd,int type)
	{
		
		//verify account add to Student.details
		boolean ret=false;
		String pd=new String(pswd).trim();
		System.out.println(pd);
		String query="SELECT * FROM user WHERE id='"+uname+"' AND password='"+pd+"'";
		String s=null;
		try{
			ConnectToDB.connect(query);
			s="";
			while(ConnectToDB.rs.next())
			{
				s=ConnectToDB.rs.getString("name")+"\t"+ConnectToDB.rs.getString("id")
						+"\t"+ConnectToDB.rs.getNString("phone")+ConnectToDB.rs.getString("email")+"\t"
						+"\t"+ConnectToDB.rs.getString("accNumber")+"\t"+ConnectToDB.rs.getString("passkey")
						+"\t"+ConnectToDB.rs.getFloat("balance")+"\t";
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
			}
		}
		return ret;
	}
}
