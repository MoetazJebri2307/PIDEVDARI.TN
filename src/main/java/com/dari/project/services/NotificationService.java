package com.dari.project.services;

import org.springframework.stereotype.Service;

import com.dari.project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class NotificationService {
	private JavaMailSender  JavaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender JavaMailSender) {
		this.JavaMailSender=JavaMailSender;
	}
	
	public void SendNotification(User user) throws MailException {
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("skander.benali@esprit.tn");
		mail.setSubject("Successfuly registred to Dari.tn");
		mail.setText("Welcome To Dari.tn \n we are happy to have you a part of us "+user.getFirstName()+"\n");
		
		JavaMailSender.send(mail);
	}
}
