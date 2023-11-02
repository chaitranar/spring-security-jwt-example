package com.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.api.entity.UserInfo;
import com.jwt.api.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void initUsers() {
		List<UserInfo> userList = Stream
				.of(new UserInfo(1234, "Chaitra", passwordEncoder.encode("pwd"), "chai@gmail.com", "ROLE_ADMIN"),
						new UserInfo(4567, "John", passwordEncoder.encode("pwd"), "john@gmail.com", "ROLE_USER"),
						new UserInfo(8910, "Max", passwordEncoder.encode("pwd"), "max@gmail.com", "ROLE_USER"))
				.collect(Collectors.toList());
		repository.saveAll(userList);
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
