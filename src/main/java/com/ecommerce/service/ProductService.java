package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.Models.Product;
import com.ecommerce.repositories.ProductRepository;

public interface ProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	List<Product> findAllById(Iterable<Integer> ids);

	Iterable<Product> findAll();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	Product save(Product entity);

}
