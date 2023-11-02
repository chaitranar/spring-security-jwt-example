package com.jwt.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwt.api.config.UserInfoUserDetails;
import com.jwt.api.entity.UserInfo;
import com.jwt.api.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> user = repository.findByUsername(username);
		return user.map(UserInfoUserDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("User Not Found!!"+username));
	}

}
