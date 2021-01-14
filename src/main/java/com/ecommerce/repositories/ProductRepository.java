package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findByNameLikeOrderByName(String name);
	
}
