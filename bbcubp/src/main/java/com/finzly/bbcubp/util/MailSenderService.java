package com.finzly.bbcubp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	public void sendMail(String toMail,String Subject,String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("barathbijili@gmail.com");
		message.setTo(toMail);
		message.setText(body);
		message.setSubject(Subject);
		mailSender.send(message);
	}

}
