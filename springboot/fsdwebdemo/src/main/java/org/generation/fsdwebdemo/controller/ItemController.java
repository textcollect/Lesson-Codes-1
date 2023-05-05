package org.generation.fsdwebdemo.controller;

import org.generation.fsdwebdemo.component.FileUploadUtil;
import org.generation.fsdwebdemo.controller.dto.ItemDTO;
import org.generation.fsdwebdemo.service.ItemService;
import org.generation.fsdwebdemo.repository.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/item") //provides a URL for frontend to call the API endpoint
public class ItemController {

	@Value("${image.folder}")
	private String imageFolder;

	private final ItemService itemService;

	// dependency injection to access ItemServiceMySQL methods
	// ItemService is the interface for ItemServiceMySQL
	public ItemController(@Autowired ItemService itemService) {
		this.itemService = itemService;
	}

	// API endpoint to return all products to the front-end
	// frontend will issue a GET http request
	@CrossOrigin
	@GetMapping("/all")
	public Iterable<Item> getItems() {
		// Display images from local folder
		for (Item image : itemService.all()) {
			String setURL = imageFolder + "/" + image.getImageUrl();
			image.setImageUrl(setURL);
		}
		// return in the Controller represents a response to the Client
		return itemService.all();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Item findItemById(@PathVariable Integer id) {
		return itemService.findById(id);
	}

	@CrossOrigin
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable Integer id) {
		itemService.deleteById(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	public void save(@RequestParam(name = "name", required = true) String name,
					 @RequestParam(name = "description", required = true) String description,
					 @RequestParam(name = "imageUrl", required = true) String imageUrl,
					 @RequestParam(name = "style", required = true) String style,
					 @RequestParam(name = "price", required = true) double price,
					 @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		//imageFolder = productimages, fileName = t-shirt_new.jpg
		FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

		//String fullPath = imageFolder + "/" + imageUrl;

		ItemDTO itemDto = new ItemDTO(name, description, imageUrl, style, price);
		itemService.save(new Item(itemDto));
	}
}
