package com.dari.project.services;

import java.util.List;

import com.dari.project.entity.Admin;
import com.dari.project.entity.Agent;
import com.dari.project.entity.Client;
import com.dari.project.entity.User;

public interface UserService {

	void ajouterClient(Client client);

	void ajouterAdmin(Admin admin);

	void ajouterAgent(Agent agent);

	void deleteAgent(Agent agent);

	void deleteAdmin(Admin admin);

	void deleteClient(Client client);

	List<User> findAllUsers();

	User findUserByEmail(String mail);

	String Login(String mail, String pass);

	List<User> findUsersByName(String name);

}
