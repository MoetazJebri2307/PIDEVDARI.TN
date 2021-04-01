package com.dari.project.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Client extends User {

	private Date DateDeNais;
	
	
	public Client(int id, String firstName, String lastname, String email, String password,String photo, Date DateDeNais) {
		super(id, firstName, lastname, email, password,photo);
		this.DateDeNais=DateDeNais;
	}
	
	public Date getDateDeNais() {
		return DateDeNais;
	}
	
	public void setDateDeNais(Date dateDeNais) {
		DateDeNais = dateDeNais;
	}
	
}
