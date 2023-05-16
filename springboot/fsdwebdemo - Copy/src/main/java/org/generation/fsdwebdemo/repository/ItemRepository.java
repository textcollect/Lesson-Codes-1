package org.generation.fsdwebdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.generation.fsdwebdemo.repository.entity.Item;

// This will be auto-implemented by Spring
// CRUD refers Create, Read, Update, Delete

// This interface will extend from the CRUDRepository provided by Springboot Framework
// then we can access all the methods from the CRUDRepository class
public interface ItemRepository extends CrudRepository<Item, Integer> {
	// T = the domain type the repository manages,
	// ID = the type of the id of the entity the repository manage

	// Nothing for now as we can just use the methods from the CrudRepository
	// For more complex system, feature, there might be other methods I need to
	// interface with the relevant class
	// (e.g. ArrayList<Item> getProductWithCategory(String categoryName);)
}
