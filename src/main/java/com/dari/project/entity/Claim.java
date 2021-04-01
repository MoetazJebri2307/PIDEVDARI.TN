package com.dari.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	private ClaimType claimType;
	private String Subject;
	private String Description;
	private int UserId; 
	
	
	
	public Claim(ClaimType claimType, String subject, String description, int userId) {
		super();
		this.claimType = claimType;
		Subject = subject;
		Description = description;
		UserId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClaimType getClaimType() {
		return claimType;
	}
	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((Subject == null) ? 0 : Subject.hashCode());
		result = prime * result + UserId;
		result = prime * result + ((claimType == null) ? 0 : claimType.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Subject == null) {
			if (other.Subject != null)
				return false;
		} else if (!Subject.equals(other.Subject))
			return false;
		if (UserId != other.UserId)
			return false;
		if (claimType != other.claimType)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimType=" + claimType + ", Subject=" + Subject + ", Description=" + Description
				+ ", UserId=" + UserId + "]";
	}
	
	
}
