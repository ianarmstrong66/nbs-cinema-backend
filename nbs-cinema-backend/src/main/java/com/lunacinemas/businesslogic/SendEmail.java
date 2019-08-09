package com.lunacinemas.businesslogic;

import com.lunacinemas.configuration.Constants;
import com.lunacinemas.model.LunaEmail;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.Properties;

public class SendEmail {
	
	public static String sendEmail(LunaEmail lunaEmail) throws MessagingException {

		final String _mimeType = "text/plain";
		String _subject = "Recipient name: " + lunaEmail.getSenderName() + 
 				"\n\nRecipient Email: " + lunaEmail.getFromEmail() +
 				"\n\nMessage: \n" +lunaEmail.getMessage();
		
		Properties props = new Properties();

		props.put("mail.user", Constants.PO_EMAIL);
		props.put("mail.password", Constants.EMAIL_PW);		
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");	
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, null);
		
		Message message = new MimeMessage(session);
		InternetAddress from = new InternetAddress(lunaEmail.getFromEmail(), false);
		message.setFrom(from);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(Constants.PO_EMAIL, false));
		message.setSubject(lunaEmail.getSubject());
		message.setSentDate(new Date());
		message.setContent(_subject, _mimeType);

		SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

		try {
			t.connect("smtp.gmail.com", Constants.PO_EMAIL, Constants.EMAIL_PW);
		  } catch (MessagingException ste) {
		    if (ste.getCause() instanceof SocketTimeoutException) {
		      try {
		        // retry on SocketTimeoutException
		    	  t.connect("smtp.gmail.com", Constants.PO_EMAIL, Constants.EMAIL_PW);
		      	System.out.println("Email retry on SocketTimeoutException succeeded");
		      } catch (MessagingException me) {
		    	  System.out.println("Email retry on SocketTimeoutException failed " + me);
		        throw me;
		      }
		    } else {
		    	System.out.println("Encountered issue while connecting to email server" + ste);
		      throw ste;
		    }
		  }
		t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	  	t.close();
	  	String response = "{\"response\":\"Message sent successfully.\"}";
	  	return response;
	}
}