package org.generation.fsdwebdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.generation.fsdwebdemo.repository.entity.Item;
import org.generation.fsdwebdemo.repository.ItemRepository;

@Service
public class ItemServiceMySQL implements ItemService {

	// Which class object is this class dependent on?
	// This ItemServiceMySQL class has to depend on another class object to perform
	//CRUD actions (e.g. save, delete, all, findItemById)
	//dependent object class is the CRUDRepository class that is provided by Spring boot

	//to perform dependency injection -> access the CRUDRepository class through the
	// ItemRepository interface that we have created

	private final ItemRepository itemRepository;

	//Dependency Injection of another class object to this class object can be done with
	// @Autowired annotation
	public ItemServiceMySQL(@Autowired ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item save(Item item) {
		// Since we have done the dependency injection of the itemRepository, therefore
		// now we can call any methods from the CRUDRepository Class
		return this.itemRepository.save(item);
	}

	@Override
	public void delete(int itemId) {
		this.itemRepository.deleteById(itemId); // dependency object(s) - CRUDRepository Class, JPARepository
	}

	@Override
	public List<Item> all() {
		List<Item> result = new ArrayList<>();
		itemRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public Item findById(int itemId) {
		// Optional is List that accept either a NULL(empty) or an Item
		Optional<Item> item = itemRepository.findById(itemId);
		Item itemResponse = item.get();
		return itemResponse;
	}
}