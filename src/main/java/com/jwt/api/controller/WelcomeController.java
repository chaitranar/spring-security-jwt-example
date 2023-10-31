package com.jwt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.api.dto.Item;
import com.jwt.api.service.ItemService;

@RestController
public class WelcomeController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Demo";
	}
	
	@GetMapping("/getAll")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}

}
