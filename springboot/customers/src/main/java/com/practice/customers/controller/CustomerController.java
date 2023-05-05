package com.practice.customers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer") //provides a URL for frontend to call the API endpoint
public class CustomerController {

	@GetMapping("/customer")
	public void customer() {

	}
}
