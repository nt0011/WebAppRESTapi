package net.javatutorial.springboot.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;

import net.javatutorial.springboot.model.User;
import net.javatutorial.springboot.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository UserRepository;	
	
	@Test
	void testGetUsers() throws Exception {
		
		User user1 = new User();
		
		user1.setId(10);
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setJob("Engineer");
		
		User user2 = new User();
		
		user2.setId(11);
		user2.setFirstName("Dave");
		user2.setLastName("Thompson");
		user2.setJob("Architect");
		
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
		
		Mockito.when(UserRepository.findAll()).thenReturn(userList); 
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", is("John")));
		
	}
	
	@Test
	void testGetUsersById() throws Exception {
		
		User userA = new User();
		userA.setId(30);
		userA.setFirstName("Will");
		userA.setLastName("Williams");
		userA.setJob("Professor");
		
		Mockito.when(UserRepository.findById((long) 30)).thenReturn(Optional.of(userA));
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", 30).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", 40).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
}

	


