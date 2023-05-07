package com.practice.customers.service;

import com.practice.customers.repository.CustomerRepository;
import com.practice.customers.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceMySQL implements CustomerService{
	//which class object is this class dependent on?
	//This ItemServiceMySQL class has to depend on another class object to perform
	// actions (e.g. save, delete, all, findItemById
	//dependent object class is the CRUDRepository class that is provided by Spring boot
	//to perform dependency injection -> access the CRUDRepository class through the
	// ItemRepository interface that we have created

	private final CustomerRepository customerRepository;

	//Dependency Injection of another class object to this class object can be done with
	// @Autowired annotation
	public CustomerServiceMySQL(@Autowired CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(int customerId) {}

	@Override
	public List<Customer> all() {
		List<Customer> result = new ArrayList<>();
		customerRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public Customer findById(int customerId) {
		// Optional is List that accept either a NULL(empty) or an Item
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer.get();
	}
}
