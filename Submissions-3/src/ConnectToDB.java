import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectToDB {
	static 	ResultSet  rs;
	static Connection con;
	public static void connect(String query) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("user", "ewallet");
		prop.setProperty("password", "ranga");

		oracle.jdbc.driver.OracleDriver ob = new oracle.jdbc.driver.OracleDriver();
		 con = ob.connect("jdbc:oracle:thin:@localhost:1521:XE", prop);
		 
		Statement ps = ConnectToDB.con.createStatement();
		rs = ps.executeQuery(query);
		
	}
}