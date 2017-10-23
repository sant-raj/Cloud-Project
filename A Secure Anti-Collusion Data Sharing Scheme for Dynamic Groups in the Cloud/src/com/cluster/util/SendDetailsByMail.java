package com.cluster.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cluster.to.RequestTO;

/**
 * @author Sharanabasu
 * 
 */
public class SendDetailsByMail {

	public static void sendOTP(RequestTO to) {
		final String username = "eerdacmacsclusterproject@gmail.com";
		final String password = "shas...3";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(
					"eerdacmacsclusterproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to.getUserEmail()));
			message.setSubject("Private key to download file");
			message.setText("Dear User," + "\n\n Use Key to download, "

			+ "Key is " + to.getStatus() + "\n\nThanks Regards"
					+ "\n\nCluster Info Solutions Pvt Ltd, Bengaluru");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
