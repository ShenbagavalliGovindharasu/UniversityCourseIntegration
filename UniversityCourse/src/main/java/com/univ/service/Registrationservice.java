package com.univ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.entity.User;
import com.univ.repository.RegistrationRepository;

@Service
	public class Registrationservice {
	
	@Autowired
	private RegistrationRepository repo;
	public User saveUser(User user) {
		
		return repo.save(user);
		
	}
	public User fetchUserByEmailId(String email) {
		
		return repo.findByEmailId(email);
	}
	
public User fetchUserByEmailIdAndPassword(String email,String Password) {
		
		return repo.findByEmailIdAndPassword(email, Password);
	}
	
	
	}
	 