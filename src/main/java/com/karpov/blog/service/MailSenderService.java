package com.karpov.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String username;

	public void sendActivationCode(String emailTo, String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom(username);
		mailMessage.setTo(emailTo);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		javaMailSender.send(mailMessage);
	}
}
