package com.dari.project.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Agent extends User {

	
	private Date ContractValidDate;
	private String Contract;
	
	
	public Agent(int id, String firstName, String lastname, String email, String password, String Photo, Date contratdate, String Contract) {
		super(id, firstName, lastname, email, password, Photo);
		this.Contract=Contract;
		this.ContractValidDate=contratdate;
	}

	
	public Date getContractValidDate() {
		return ContractValidDate;
	}

	public void setContractValidDate(Date contractValidDate) {
		ContractValidDate = contractValidDate;
	}

	public String getContract() {
		return Contract;
	}

	public void setContract(String contract) {
		Contract = contract;
	}
	
}
