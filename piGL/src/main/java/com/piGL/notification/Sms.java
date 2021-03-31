package com.piGL.notification;

public class Sms {
	
	private String to;
    private String message;
    
    
    
	public Sms(String to, String message) {
		super();
		this.to = to;
		this.message = message;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
