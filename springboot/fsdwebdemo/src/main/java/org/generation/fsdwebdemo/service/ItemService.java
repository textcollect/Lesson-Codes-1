package org.generation.fsdwebdemo.service;

import java.util.List;
import org.generation.fsdwebdemo.repository.entity.Item;

public interface ItemService {
	//save method is for 2 purposes - Create new item & Update existing item
	Item save(Item item);

	//Delete item from database - based on item Id
	void deleteById(int itemId);

	//Read all item from database
	List<Item> all();

	//Read an item from database - based on item Id
	Item findById(int itemId);
}
