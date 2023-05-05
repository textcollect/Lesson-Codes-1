package org.generation.fsdwebdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.generation.fsdwebdemo.repository.entity.Item;

// This will be auto-implemented by Spring
// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Item, Integer> {
	// T = the domain type the repository manages,
	// ID = the type of the id of the entity the repository manage
}
