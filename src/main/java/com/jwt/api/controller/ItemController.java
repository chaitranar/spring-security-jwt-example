package com.jwt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.api.dto.Item;
import com.jwt.api.entity.UserInfo;
import com.jwt.api.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
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
	

}
