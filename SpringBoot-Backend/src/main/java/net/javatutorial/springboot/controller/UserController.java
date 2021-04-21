package net.javatutorial.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javatutorial.springboot.exception.UserNotFoundException;
import net.javatutorial.springboot.model.User;
import net.javatutorial.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping     
public class UserController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/users")
	public List<User> getUsers(){
			return this.UserRepository.findAll();
	}	
	
	/*@PostMapping("/users")
	public User newUser(@RequestBody User newUser) {
		return UserRepository.save(newUser);
	}*/
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
	    
	    User user = UserRepository.findById(id)
	      .orElseThrow(() -> new UserNotFoundException(id));
	    
	    if(user == null) {
	    	return new ResponseEntity(HttpStatus.NOT_FOUND);
	    }
	    else {
	    	return new ResponseEntity(user, HttpStatus.OK);
	    }
	  }
		
	/*@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		UserRepository.deleteById(id);
	}*/
}
	


