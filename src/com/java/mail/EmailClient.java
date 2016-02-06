package com.java.mail;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailClient {

	public static void main(String[] args) {
		String TO="akhilesh.kumar@in.ey.com";
		String FROM="aakash.gupta140@live.com";
		String host="localhost";
		Properties properties=System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session=Session.getDefaultInstance(properties);
		
		try{
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(RecipientType.TO, new InternetAddress(TO));
			message.setSubject("Message from Java");
			message.setText("Hi!! there. This mail has been sent from a java program.");
			Transport.send(message);
		}catch(MessagingException me){
			me.printStackTrace();
		}
	}
}