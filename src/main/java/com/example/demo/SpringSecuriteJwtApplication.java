package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecuriteJwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers(){
		 List<User> users = Stream.of(
		 		new User(101,"javatechie","password","javatech@gmail.com"),
				 new User(102,"user1","user1","user1@gmail.com"),
				 new User(103,"user2","user2","user2@gmail.com")


		 ).collect(Collectors.toList());
		 repository.saveAll(users);
	 }
	public static void main(String[] args) {
		SpringApplication.run(SpringSecuriteJwtApplication.class, args);
	}

}
