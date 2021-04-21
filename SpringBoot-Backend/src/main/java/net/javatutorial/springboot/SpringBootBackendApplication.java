package net.javatutorial.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javatutorial.springboot.model.User;
import net.javatutorial.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringBootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
	}

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public void run(String... args) throws Exception {
		this.UserRepository.save(new User("John", "Doe", "Engineer"));
		this.UserRepository.save(new User("Jane", "Doe", "Teacher"));
		this.UserRepository.save(new User("Dave", "Smith", "Doctor"));
	}

}
