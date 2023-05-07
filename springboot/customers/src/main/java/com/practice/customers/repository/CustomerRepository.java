package com.practice.customers.repository;

import com.practice.customers.repository.entity.Customer;
import org.springframework.data.repository.CrudRepository;

// This will be auto-implemented by Spring
// CRUD refers Create, Read, Update, Delete
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	// T = the domain type the repository manages,
	// ID = the type of the id of the entity the repository manage
}
