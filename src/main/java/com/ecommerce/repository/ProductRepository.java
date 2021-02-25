package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	Iterable<Product> findByCategoryAndDeletedFalse(Category category);

	boolean existsByName(String name);

	Product findByName(String name);

}
