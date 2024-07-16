package com.api.rest.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.api.rest.backend.models.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(EmailRequest emailRequest) {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(emailRequest.getTo());
			helper.setSubject(emailRequest.getSubject());
			helper.setText(emailRequest.getText(), true); // true indica que o conteúdo é HTML

			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			// Tratar a exceção de forma apropriada, se necessário
		}
	}
}
