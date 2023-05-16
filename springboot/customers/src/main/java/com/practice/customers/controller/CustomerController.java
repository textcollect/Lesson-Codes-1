package com.practice.customers.controller;

import com.practice.customers.controller.dto.CustomerDTO;
import com.practice.customers.repository.entity.Customer;
import com.practice.customers.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer") //provides a URL for frontend to call the API endpoint
public class CustomerController {

	private final CustomerService customerService;

	// dependency injection to access CustomerServiceMySQL methods
	// CustomerService is the interface for CustomerServiceMySQL
	public CustomerController(@Autowired CustomerService customerService) {
		this.customerService = customerService;
	}

	// API endpoint to return all products to the front-end
	// frontend will issue a GET http request
	@CrossOrigin
	@GetMapping("/all")
	public Iterable<Customer> getCustomers() {
		// return in the Controller represents a response to the Client
		return customerService.all();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Customer findItemById(@PathVariable Integer id) {
		return customerService.findById(id);
	}

	@CrossOrigin
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable Integer id) {
		customerService.delete(id);
	}

	// Add & save new customer to CustomerService object which actually saves to the CustomerRepository
	// which is linked to the Customer table in db
	@CrossOrigin
	@PostMapping("/add")
	public void save(@RequestParam(name = "name", required = true) String name,
					 @RequestParam(name = "mobile", required = true) int mobile) {

		CustomerDTO customerDTO = new CustomerDTO(name, mobile);
		customerService.save(new Customer(customerDTO));
	}

}
