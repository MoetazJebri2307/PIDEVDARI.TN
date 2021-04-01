package com.dari.project.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	private String ContactMail;
	private int ProfessionalNumber;
	
	
	
	
	public Admin() {
		super();
	}

	public Admin(int id, String firstName, String lastname, String email, String password, String Photo, String contact, int number) {
		super(id, firstName, lastname, email, password, Photo);
		this.ContactMail=contact;
		this.ProfessionalNumber=number;
	}

	public String getContactMail() {
		return ContactMail;
	}

	public void setContactMail(String contactMail) {
		ContactMail = contactMail;
	}

	public int getProfessionalNumber() {
		return ProfessionalNumber;
	}

	public void setProfessionalNumber(int professionalNumber) {
		ProfessionalNumber = professionalNumber;
	}

}
