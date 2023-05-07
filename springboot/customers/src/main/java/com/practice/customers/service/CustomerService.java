package com.practice.customers.service;

import com.practice.customers.repository.entity.Customer;

import java.util.List;

public interface CustomerService {
	//save method is for 2 purposes - Create new item & Update existing item
	Customer save(Customer customer);

	//Delete item from database - based on item Id
	void deleteById(int customerId);

	//Read all item from database
	List<Customer> all();

	//Read an item from database - based on item Id
	Customer findById(int customerId);
}
