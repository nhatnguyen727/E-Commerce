package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
}
