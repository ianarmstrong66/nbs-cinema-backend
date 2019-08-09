package com.lunacinemas.model;

public class LunaEmail {

	private String senderName;
	private String fromEmail;
    private String subject;
    private String message;
    
    public LunaEmail(String senderName,String fromEmail, String subject, String message) {
    	this.senderName = senderName;
        this.fromEmail = fromEmail;
        this.subject = subject;
        this.message = message;
    }
    
    public void setValues(String senderName, String fromEmail, String subject, String message) {
        this.senderName = senderName;
    	this.fromEmail = fromEmail;
        this.subject = subject;
        this.message = message;
    }

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
