package com.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jwt.api.entity.User;
import com.jwt.api.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository repository;
	
	/*
	 * @PostConstruct public void initUsers() { List<User> userList = Stream.of( new
	 * User(1234,"Chaitra","password", "chai@gmail.com"), new User(4567, "John" ,
	 * "password", "john@gmail.com"), new User(8910, "Max" , "password",
	 * "max@gmail.com") ).collect(Collectors.toList());
	 * repository.saveAll(userList); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
