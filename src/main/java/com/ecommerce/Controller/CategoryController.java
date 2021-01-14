package com.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Models.Category;
import com.ecommerce.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> list() {
	    return (List<Category>)categoryService.findAll();
	}
	@PostMapping("")
	public void insert(@RequestBody Category category) {
		categoryService.save(category);
	}
	@GetMapping("/{id}")
	public Optional<Category> get(@PathVariable(name="id") Integer id) {
		Optional<Category> category = categoryService.findById(id);
		return category;
	}	
}
