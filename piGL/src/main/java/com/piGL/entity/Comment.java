package com.piGL.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	public Comment(String description, int reply, int ref, Annoce annoce) {
		super();
		this.description = description;
		this.reply = reply;
		this.ref = ref;
		this.annoce = annoce;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String description ; 
	
	private int reply ;
	
	private int ref ;
	
	@ManyToOne()
   
	private Annoce annoce;

	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", reply=" + reply + ", ref=" + ref + ", annoce="
				+ annoce + "]";
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public Annoce getAnnoce() {
		return annoce;
	}

	public void setAnnoce(Annoce annoce) {
		this.annoce = annoce;
	}

}
