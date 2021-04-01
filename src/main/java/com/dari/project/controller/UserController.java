package com.dari.project.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dari.project.entity.Admin;
import com.dari.project.entity.Agent;
import com.dari.project.entity.Client;
import com.dari.project.entity.LoginRequest;
import com.dari.project.entity.User;
import com.dari.project.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.dari.project.services.NotificationService;
import org.springframework.mail.MailException;
@RestController
public class UserController {
	@Autowired 
	private UserService userService;
	
	@Autowired
	private NotificationService NotificationService;
	
	
	@GetMapping("/adminregister")
	public String ajouterAdmin(@RequestBody Admin admin) 
	{
		userService.ajouterAdmin(admin);
		try {
			NotificationService.SendNotification(admin);
		}catch(MailException e) {
			
		}
		return "niiiice ! " ;
	}
	
	@GetMapping("/Agentregister")
	public void ajouterAgent(@RequestBody Agent agent)
	{
		userService.ajouterAgent(agent);
	}
	
	@GetMapping("/Clientregister")
	public void ajouterClient(@RequestBody Client client)
	{
		userService.ajouterClient(client);
		
		try {
			NotificationService.SendNotification(client);
		}catch(MailException e) {
			
		}
	}
	
	@GetMapping("/agentdelete")
	public void deleteAgent(@RequestBody Agent agent)
	{
		userService.deleteAgent(agent);
	}
	
	@GetMapping("/admindelete")
	public void deleteAdmin(@RequestBody Admin admin)
	{
		userService.deleteAdmin(admin);
	}
	
	@GetMapping("/clientdelete")
	public void deleteClient(@RequestBody Client client)
	{
		userService.deleteClient(client);
	}
	
	@GetMapping("/AllUsers")
	public List<User> RetAll() {
		return userService.findAllUsers(); 
		 
	}
	
	@GetMapping("/Profil")
	public User findUserEmail(@RequestBody String mail) {
		return userService.findUserByEmail(mail); 
		 
	}
	
	@GetMapping("/UserByName")
	public List<User> findUserName(@RequestBody String name) {
		return userService.findUsersByName(name); 
		 
	}
	
	
	@GetMapping("/loginapp")
	public String LoginUser(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getEmailConnect());
	return	userService.Login(loginRequest.getEmailConnect(),loginRequest.getPass()); 
	}
	
	/*@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setEmail(username);
		user.setPassword(pwd);
		user.setToken(token);		
		return user;
		
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}*/
	
}
