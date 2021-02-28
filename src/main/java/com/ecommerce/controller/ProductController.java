package com.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@RestController
public class ProductController {

	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;

	@Autowired
	public ProductController(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	@GetMapping("/product/{id}")
	public Optional<Product> get(@PathVariable("id") Integer id) {
		return productRepo.findById(id);
	}

	@GetMapping("/product/category={id}")
	public Iterable<Product> getByCategory(@PathVariable("id") int id) {
		return productRepo.findByCategoryAndDeletedFalse(categoryRepo.findById(id).get());
	}

	@PostMapping("/admin/product")
	public ResponseEntity<String> insert(@Valid @RequestBody Product product, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(
					errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
					HttpStatus.FORBIDDEN);
		}
		if (productRepo.existsByName(product.getName())) {
			return new ResponseEntity<>("product name already exists!", HttpStatus.CONFLICT);
		}
		productRepo.save(product);
		return null;
	}

	@PutMapping("/admin/product/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @Valid @RequestBody Product product,
			Errors errors) {
		if (productRepo.existsById(id) && id == product.getId()) {
			if (errors.hasErrors()) {
				return new ResponseEntity<>(
						errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
						HttpStatus.FORBIDDEN);
			}
			if (productRepo.existsByName(product.getName())) {
				if (productRepo.findByName(product.getName()).getId() != id) {
					return new ResponseEntity<>("product name already exists!", HttpStatus.CONFLICT);
				}
			}
			productRepo.save(product);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/product/{id}")
	public ResponseEntity<Product> delete(@PathVariable("id") int id) {
		if (productRepo.existsById(id)) {
			Product p = productRepo.findById(id).get();
			p.setDeleted(true);
			productRepo.save(p);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
