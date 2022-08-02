package com.javabulkemail.bulkemailsender;


import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaMailSender {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter From-Email Address: ");
		String email = scn.nextLine();
		
		System.out.println("Enter Password(If 2FA is enabled use application password): ");
		String password = scn.nextLine();
		
		System.out.println("Enter To-Email Address: ");
		String toEmail = scn.nextLine();
		
		System.out.println("Enter Subject: ");
		String subject = scn.nextLine();
		
		System.out.println("Enter Message: ");
		String message = scn.nextLine();
		
		System.out.println("Enter Total Number of Emails To Send: ");
		int totalMessagesToSend = scn.nextInt();
		
		scn.close();
		
		System.out.println("preparing to send message ...");
		try {
			sendEmail(email, password, toEmail, subject, message, totalMessagesToSend);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static void sendEmail(final String email, final String password, final String toEmail, final String subject2, final String message, int totalMessagesToSend) throws AddressException, MessagingException {
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}

		});
		
		MimeMessage m = new MimeMessage(session);
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		m.setFrom(email);
		m.setText(message);
		
		try {
			for (int i = 1; i <= totalMessagesToSend; i++) {
				System.out.println("Sending email :" + i);
				m.setSubject(subject2 + i);
				Transport.send(m);
				System.out.println("Email send sucessfull........");
				Thread.sleep(2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
