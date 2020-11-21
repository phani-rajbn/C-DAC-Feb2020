package com.training.day8;

//MailAPi of java...

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Ex04 {
	//mail.jar and activation.jar
	public static void main(String[] args) {
		String toAddress = "phanirajbn@gmail.com";
		String fromAddress = "phanirajbn@yahoo.in";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.server", "localhost");
		Session session = Session.getDefaultInstance(properties);
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromAddress));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
			msg.setSubject("Test Message for Demo");
			msg.setText("Content of UR Email");
			
			Transport.send(msg);
			System.out.println("Message Sent successfully");
		}catch(MessagingException e) {
			e.printStackTrace();
		}

	}

}
//Complete the Client server application for Sockets.
//Create Serialization Demo with interface programming. 
//Retain the interface as public. 
//Download the JDBC jar file for mysql.
//mysql database in UR machine. 