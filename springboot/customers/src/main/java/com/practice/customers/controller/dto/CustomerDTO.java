package com.practice.customers.controller.dto;

// The ItemDTO Class will interface with the Client (Browser) for any HTTP request
//(e.g. GET, POST, PUT, DELETE methods) and is wired to the ItemService Class to perform
//getItem, addItem, findItem, updateItem and deleteItem.
public class CustomerDTO {
	// variable names same as table column names
	// id is excluded as it is auto-generated
	private String name;
	private int mobile;

	// Constructor
	public CustomerDTO(String name, int mobile) {
		this.name = name;
		this.mobile = mobile;
	}

	// Standard Getter & Setter methods

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
}
