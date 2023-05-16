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

// Azure Blob Storage
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

// Request mapping is to provide a URL route for frontend to call
//controller for /item, /user, /customer, /post
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

//		// Display images from local folder
//		for (Item image : itemService.all()) {
//			// productimages/t-shirt1.jpg
//			String setURL = imageFolder + "/" + image.getImageUrl();
//			image.setImageUrl(setURL);
//			// System.out.println(image.getImageUrl());
//		}


		/* To display images from the Server Container */
		String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=productimagedemotp;AccountKey=8rVndJyQp9GYHFGMyAyvT2NlNoICsH4FTGlgHIDBt1TrjtEUNdq7jT80o65NIxSQSaY1C6clQfgb+AStZNbTOg==;EndpointSuffix=core.windows.net";
		//System.out.println("Connect String: " + connectStr2);
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
		String containerName = "prodimage";
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

		//productimagedemotp
		BlobClient blobClient = containerClient.getBlobClient(itemService.all().get(0).getImageUrl());

		//Loop through the ArrayList of itemService.all() and append the Blob url to the imageUrl
		for (Item image : itemService.all()) {
			// path: productimagedemotp/prodimage/t-shirt1.jpg
			String setURL = blobClient.getAccountUrl() + "/" + containerName + "/" + image.getImageUrl();
			image.setImageUrl(setURL);
		}

		// return in the Controller represents a response to the Client
		return itemService.all();
	}

	// The id value will be sent from the front-end through the API URL parameter
	@CrossOrigin
	@GetMapping("/{id}")
	public Item findItemById(@PathVariable Integer id) {
		return itemService.findById(id);
	}

	@CrossOrigin
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable Integer id) {
		itemService.delete(id);
	}

	// Add & save new item to ItemService object which actually saves to the ItemRepository
	// which is linked to the Item table in db
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
