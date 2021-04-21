package net.javatutorial.springboot.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import net.javatutorial.springboot.model.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void testUserRepository() {
		
		List<User> users = testRestTemplate.getForObject("http://localhost:" + port + "/users", List.class);
		
		Assertions.assertNotNull(users);
		Assertions.assertEquals(3, users.size());
		
	}

}
