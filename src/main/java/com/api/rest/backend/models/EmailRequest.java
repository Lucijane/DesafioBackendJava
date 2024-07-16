package com.api.rest.backend.models;

public class EmailRequest {
	private String to;
	private String subject;
	private String text;

	// Construtor vazio necessário para frameworks como Spring Boot
	public EmailRequest() {
	}

	// Construtor com todos os campos
	public EmailRequest(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	// Getters e Setters
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
