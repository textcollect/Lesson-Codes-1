package org.generation.fsdwebdemo.controller.dto;

// The ItemDTO Class will interface with the Client (Browser) for any HTTP request
//(e.g. GET, POST, PUT, DELETE methods) and is wired to the ItemService Class to perform
//getItem, addItem, findItem, updateItem and deleteItem.
public class ItemDTO {
	// variable names same as table column names
	// id is excluded as it is auto-generated
	private String name;
	private String description;
	private String imageUrl;
	private String style;
	private double price;

	// Constructor
	public ItemDTO(String name, String description, String imageUrl, String style, double price) {
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.style = style;
		this.price = price;
	}

	// Standard Getter & Setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}
