package com.user.panel.project.util;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	static String getChar = "";
	static String getCode = "";

	public static void send(String otp) {
		final String username = "ponir.saha@gmail.com";
		final String password = "Bangla@4577";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("otp@yourbank.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ponir@live.com"));
			message.setSubject("OTP");
			message.setText("Dear User," + "\n\n Your OTP is : " + otp + "\n\n\nPlease use it within 1 Min.");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String generateOtpCode() {
		int leftLimit = 97;
		int rightLimit = 122;
		int targetLength = 1;
		Random random = new Random();
		StringBuilder singeOtp = new StringBuilder(targetLength);
		for (int i = 0; i < targetLength; i++) {
			int randomInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			singeOtp.append((char) randomInt);
		}
		int numricCode = random.nextInt(999999);
		return singeOtp.toString().toUpperCase() + "-" + String.format("%06d", numricCode);
	}

	public static boolean isValidate() {
		String generatedOtp = generateOtpCode();
		send(generatedOtp);
		getChar = generatedOtp.substring(0, 1);
		getCode = generatedOtp.substring(2, generatedOtp.length());
		System.out.print("Enter code: " + getChar + "-");
		Scanner scanner = new Scanner(System.in);
		String inputOtp = scanner.next();
		scanner.close();
		return inputOtp.contentEquals(getCode);
	}

}
