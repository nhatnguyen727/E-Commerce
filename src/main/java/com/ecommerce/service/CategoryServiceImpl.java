package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.Category;
import com.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired 
	CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category entity) {
		return categoryRepository.save(entity);
	}
	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	} 
	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}
	@Override
	public List<Category> findAllById(Iterable<Integer> ids) {
		return (List<Category>) categoryRepository.findAllById(ids);
	}

}
