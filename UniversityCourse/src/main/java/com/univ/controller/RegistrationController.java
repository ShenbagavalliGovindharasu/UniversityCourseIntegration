package com.univ.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.univ.entity.User;
import com.univ.exception.BadcredentialsException;
import com.univ.exception.DuplicateUserMailIdException;
import com.univ.service.Registrationservice;

@RestController
public class RegistrationController 
{
	
	@Autowired
	private Registrationservice service;
	
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws DuplicateUserMailIdException {
		
		String tempEmailId = user.getEmailId();
		
		if(tempEmailId!= null && !"".equals(tempEmailId)) {
		User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new DuplicateUserMailIdException("user with "+tempEmailId+"already exist");
			}			
		}
		User userobj = null;
		userobj = service.saveUser(user);
		return userobj;
		
	}	
	
	@PostMapping("/log")
	public User loginUser(@RequestBody User user)  {
		String tempEmailId= user.getEmailId();
		String tempPass = user.getPassword();
       User userobj =null;
	 if(tempEmailId != null && tempPass != null) {
		 userobj=service.fetchUserByEmailIdAndPassword(tempEmailId ,tempPass);
	 }
	 if(userobj ==null) {
		 throw new BadcredentialsException("Bad credentials! check your MailId or Password");
	 }
	 return userobj;
	}
}