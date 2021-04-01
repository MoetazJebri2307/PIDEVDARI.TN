package com.dari.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dari.project.entity.Admin;
import com.dari.project.entity.Agent;
import com.dari.project.entity.Client;
import com.dari.project.entity.User;
import com.dari.project.repository.AdminRepository;
import com.dari.project.repository.AgentRepository;
import com.dari.project.repository.ClientRepository;
import com.dari.project.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public void ajouterClient(Client client) {
		client.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
		clientRepository.save(client);
		
	}
	
	@Override
	public void ajouterAdmin(Admin admin) {
		admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
		adminRepository.save(admin);	
	}
	
	@Override
	public void ajouterAgent(Agent agent) {
		agent.setPassword(new BCryptPasswordEncoder().encode(agent.getPassword()));
		agentRepository.save(agent);
	}
	
	@Override
	public void deleteAgent(Agent agent) {
		agentRepository.delete(agent);
	}
	
	@Override
	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
	}
	
	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}
	

	@Override
	public List<User> findAllUsers(){
		List<User> users = (List<User>) userRepository.findAll(); 
		return users ; 
	}
	
	public void updateUser(String email, String password) {
	User usr = findUserByEmail(email);
    usr.setPassword(password); 
    userRepository.save(usr);
	}
	
	@Override
	public User findUserByEmail(String mail) {
		User user1= null ;
		List<User> users = findAllUsers();
		for (User user:users) {
			if (user.getEmail().equals(mail)) {
				user1 = user ; 
			}
		}
		return user1 ; 
	}
	

	@Override
	public List<User> findUsersByName(String name){
		List<User> users = findAllUsers();
		List<User> userss = new ArrayList<>();
		for (User user:users) {
			if (user.getFirstName().equals(name)) {
				System.out.println(user);
				userss.add(user) ; 
			}
		}
		return userss ; 
	}
	
	@Override
	public String Login(String mail , String pass) {
		boolean match = false ; 
		String wlc = null ;
		List<User> users = findAllUsers();
		for (User user:users) {
			if (user.getEmail().equals(mail)) {
				match = new BCryptPasswordEncoder().matches(pass, user.getPassword());
				wlc=user.getFirstName(); 
			}
		}
		if (match==true) {
			return ("Welcome " + wlc); 
		}
		else {
			return ("Incorrect Email or Password "); 
		}
	}
	
	
	
}
