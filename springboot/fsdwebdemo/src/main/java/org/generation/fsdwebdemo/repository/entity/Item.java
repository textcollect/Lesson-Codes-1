package org.generation.fsdwebdemo.repository.entity;

//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database

import org.generation.fsdwebdemo.controller.dto.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Item {
	//Properties/attributes - will be mapped to the columns of the database table
	//Need to use the Wrapper class on primitive data types - need to pass the datatype
	// as an object to CRUDRepository Class (provided by SpringBoot framework)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;             //retrieve product item by ID - has to be an object
	private String name;
	private String description;
	private String imageUrl;
	private String style;
	private double price;

	// Item class used to map w the Database table
	// Any CRUD operation, JPA will make use of this Item class to map
	// For Read or Delete operation, the JPA requires empty constructor to
	//populate all the records from the db
	protected Item() {
		// no-args constructor required by JPA spec
		// this one is protected since it should not be used directly
	}

	// DTO = Data Transfer Object
	// Create and Update operation, JPA requires the ItemDTO object to
	//be sent via the controller
	public Item(ItemDTO itemDTO) {
		//Transfer the object (with the data) to Entity Class from ItemDTO for mapping
		// with the database table columns and to be able to save the data in the columns
		this.name = itemDTO.getName();
		this.description = itemDTO.getDescription();
		this.imageUrl = itemDTO.getImageUrl();
		this.style = itemDTO.getStyle();
		this.price = itemDTO.getPrice();
	}

	// Getter & Setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='" + imageUrl + '\'' + ",style='" + style + '\'' + ", price='" + price + '}';
	}
}
