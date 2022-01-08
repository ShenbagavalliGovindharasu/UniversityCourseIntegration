package com.univ.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.univ.entity.User;
import com.univ.exception.BadcredentialsException;
import com.univ.repository.RegistrationRepository;
import com.univ.service.Registrationservice;

@SpringBootTest
class Springdemo1ApplicationTests {
	
	@Autowired
	private  Registrationservice service;

	@MockBean
	private RegistrationRepository repo;

	@Test
	public void saveUserTest() {
		User u=new User(2,"abce@gmail.com","teena","46789");
		when(repo.save(u)).thenReturn(u);
		assertEquals(u,service.saveUser(u));
	
	}
	
	@Test
	
	public void finduserById() {
		
		
			User u=new User(2,"a3bcc@gmail.com","roodu","2web5ced");
			repo.findByEmailId("a3bcc@gmail.com");
			verify(repo,times(1)).findByEmailId("a3bcc@gmail.com");
		
		
		
	}
	/*public void should_throw_exception_when_user_doesnt_exist() throws Exception {
		User user = new User();
		user.setId(3);
		user.setUserName("bbcdc");
		Mockito.doThrow(new BadcredentialsException(user.getEmailId())).when(service).fetchUserByEmailId("adfrh@gmail.com");
		Mvc.perform(get("bbcdc" + user.getEmailId().toString())
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
		}*/

}
