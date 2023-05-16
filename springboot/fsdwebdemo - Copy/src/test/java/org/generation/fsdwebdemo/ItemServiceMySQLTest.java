package org.generation.fsdwebdemo;

import org.generation.fsdwebdemo.repository.ItemRepository;
import org.generation.fsdwebdemo.repository.entity.Item;
import org.generation.fsdwebdemo.service.ItemService;
import org.generation.fsdwebdemo.service.ItemServiceMySQL;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

@SpringBootTest
public class ItemServiceMySQLTest {

	// 1) Which Class object to be tested: ItemServiceMySQL
	// 2) What are the dependency objects for the testing class object
	//		a) ItemRepository (@Autowired)
	//		b) Item
	@Mock
	ItemRepository itemRepository;

	// Why use the ItemService Interface class
	// all classes access ItemServiceMySQL object through the interface (ItemService)
	ItemService itemService;
	Item itemMock;

	// Before every test, I want to re-setup/re-initialize the itemService and itemMock
	@BeforeEach
	public void setup() {
		itemService = new ItemServiceMySQL(itemRepository);
		itemMock = Mockito.mock(Item.class);
	}

	@Test
	public void saveCallsItemsRepositorySave() {
		// public Item save(Item item)
		itemService.save(itemMock);

		// itemRepository.save(item)
		Mockito.verify(itemRepository).save(itemMock);
	}

	@Test
	public void deleteCallsItemsRepositoryDelete() {
		int itemId = 2;

		// public void delete(int itemId)
		itemService.delete(itemId);

		// itemRepository.deleteById(itemId)
		Mockito.verify(itemRepository).deleteById(itemId);
	}

	@Test
	public void findByIdCallsItemsRepositoryFindById() {
		int itemId = 10;

		// Optional<Item> item = itemRepository.findById(itemId);
		// Item itemResponse = item.get();
		Mockito.when(itemRepository.findById(itemId)).thenReturn(Optional.of(itemMock));

		// public Item findById(int itemId)
		Item item = itemService.findById(itemId);
		Assertions.assertEquals(item, itemMock);
	}

	@Test
	public void listCallsItemsRespositoryList() {
		itemService.all();
		Mockito.verify(itemRepository).findAll();
	}

}