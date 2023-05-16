package org.generation.fsdwebdemo;

import org.generation.fsdwebdemo.controller.ItemController;
import org.generation.fsdwebdemo.service.ItemService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemControllerTest {
	ItemService itemService;
	ItemController itemController;


	@BeforeEach
	public void setup() {

		itemService = Mockito.mock(ItemService.class);
		itemController = new ItemController(itemService);
	}

//	@Test
//	public void listItemService() {
//		itemController.getItems();
//		Mockito.verify(itemService).all();
//	}


	@Test
	public void findItemService() {
		int id = 2;
		itemController.findItemById(id);
		Mockito.verify(itemService).findById(id);
	}


	@Test
	public void deleteItemService() {
		int id = 2;
		itemController.delete(id);
		Mockito.verify(itemService).delete(id);
	}

}
