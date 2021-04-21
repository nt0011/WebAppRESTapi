package net.javatutorial.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javatutorial.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
