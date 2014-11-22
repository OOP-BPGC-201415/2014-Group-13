import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteLog 
{
	public WriteLog(String a)
	{
		try
		{	
			BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\log.txt"));
			bw.write(a);
			
			bw.close();
		}
		catch(Exception e){}
	}
	
	public static String getDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
