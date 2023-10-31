package com.jwt.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jwt.api.dto.Item;


@Service
public class ItemService {
	
	List<Item> itemList = Arrays.asList(
			new Item(1, "car", 20, 100),
			new Item(1, "truck", 20, 100),
			new Item(1, "jeep", 20, 100)
			);

	public List<Item> getAllItems() {
		return itemList;
	}
	

}
