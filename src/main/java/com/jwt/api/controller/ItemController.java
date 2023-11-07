package com.jwt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.api.dto.Item;
import com.jwt.api.entity.AuthRequest;
import com.jwt.api.service.ItemService;
import com.jwt.api.service.JwtService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Demo";
	}
	
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/getItem/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Item getItem(@PathVariable Integer id) {
		return itemService.getItem(id);
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid user!!!");
		}
	}
	

}
