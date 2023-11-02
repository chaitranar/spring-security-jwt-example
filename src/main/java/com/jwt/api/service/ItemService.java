package com.jwt.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.api.dto.Item;
import com.jwt.api.entity.UserInfo;
import com.jwt.api.repository.UserRepository;


@Service
public class ItemService {
	
	@Autowired
	private UserRepository repository;
	
	List<Item> itemList = Arrays.asList(
			new Item(1, "car", 20, 100),
			new Item(2, "truck", 20, 100),
			new Item(3, "jeep", 20, 100)
			);

	public List<Item> getAllItems() {
		return itemList;
	}

	public Item getItem(Integer id) {
		Item item = itemList.stream().filter(i->id.equals(i.getItemId())).findFirst().orElseThrow(()->new RuntimeException("Item id:"+id+" NotFound"));
		return item;
	}

}
