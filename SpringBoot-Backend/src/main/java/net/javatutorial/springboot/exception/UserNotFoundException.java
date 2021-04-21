package net.javatutorial.springboot.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long id) {
	    super("User " + id + " is not in the system");
	  }

}
