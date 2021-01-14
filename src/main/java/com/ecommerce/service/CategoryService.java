package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.Category;

public interface CategoryService {

	List<Category> findAllById(Iterable<Integer> ids);

	Iterable<Category> findAll();

	Optional<Category> findById(Integer id);

	Category save(Category entity);

}
