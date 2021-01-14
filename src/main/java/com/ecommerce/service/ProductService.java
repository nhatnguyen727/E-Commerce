package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.Product;

public interface ProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void delete(Product entity);

	void deleteById(Integer id);

	int count();

	List<Product> findAllById(Iterable<Integer> ids);

	Iterable<Product> findAll();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	Product save(Product entity);

	List<Product> findByNameLikeOrderByName(String name);


}
