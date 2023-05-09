package com.practice.customers.repository.entity;

//Repository package is part of the Model Component (MVC)
//Customer is the entity class to use to map against the table from the database

import com.practice.customers.controller.dto.CustomerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	//Properties/attributes - will be mapped to the columns of the database table
	//Need to use the Wrapper class on primitive data types - need to pass the datatype
	// as an object to CRUDRepository Class (provided by SpringBoot framework)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //retrieve customer by ID - has to be an object
	private String name;
	private int mobile;

	// Customer class used to map w the Database table
	// Any CRUD operation, JPA will make use of this Item class to map
	// For Read or Delete operation, the JPA requires empty constructor to
	//populate all the records from the db
	protected Customer() {
		// no-args constructor required by JPA spec
		// this one is protected since it should not be used directly
	}

	// DTO = Data Transfer Object
	// Create and Update operation, JPA requires the ItemDTO object to
	//be sent via the controller
	public Customer(CustomerDTO customerDTO) {
		//Transfer the object (with the data) to Entity Class from CustomerDTO for mapping
		// with the database table columns and to be able to save the data in the columns
		this.name = customerDTO.getName();
		this.mobile = customerDTO.getMobile();
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", mobile='" + mobile + '}';
	}
}
