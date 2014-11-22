import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


public class SendeMail 
{
	static String from="shanmukharanganath@gmail.com";
	public static boolean sendeMail(String to,String subj,String body)
	   {    
		boolean sent=false;
	      String host = "smtp.gmail.com";
	      
	      final String username = "";//change accordingly
	      final String password = "";//change accordingly

	      // Get system properties
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the default Session object.
	      Session session = Session.getInstance(props,
	    	      new javax.mail.Authenticator() {
	    	         protected PasswordAuthentication getPasswordAuthentication() {
	    	            return new PasswordAuthentication(username, password);
	    	         }
	    	      });

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(subj);

	         // Now set the actual message
	         message.setText(body);

	         // Send message
	         Transport.send(message);
	         sent=true;
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         new WriteLog(mex+"\n");
	      }
	      finally{return sent;}
	   }
}
