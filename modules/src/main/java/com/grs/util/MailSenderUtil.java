package com.grs.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailSenderUtil {

	@Autowired
	private MailSender mailSender;
	private static final Logger LOGGER = LogManager.getLogger();

	public void sendMail(String to, String subject, String body) {
		LOGGER.info("sendMail method invoked");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		mailSender.send(mailMessage);
	}
}
