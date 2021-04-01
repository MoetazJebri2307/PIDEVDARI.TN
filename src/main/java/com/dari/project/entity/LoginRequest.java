package com.dari.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	private String EmailConnect ; 
	private String Pass ;
	
	public LoginRequest() {
		super();
	}

	

	public LoginRequest(String emailConnect, String pass) {
		super();
		EmailConnect = emailConnect;
		Pass = pass;
	}



	public String getEmailConnect() {
		return EmailConnect;
	}

	public void setEmailConnect(String emailConnect) {
		EmailConnect = emailConnect;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	} 
	
	

}
