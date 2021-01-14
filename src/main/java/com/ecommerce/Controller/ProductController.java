package com.ecommerce.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Models.Product;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.service.ProductService;


public class ProductController {
	@Autowired
	private ProductService productService;


	@PostMapping("")
	public void insert(@RequestBody Product product) {
		productService.save(product);
	}
	@GetMapping("")
	public List<Product> list() {
	    return (List<Product>)productService.findAll();
	}
	@PutMapping("/{id}/upd")
	public Product update(@PathVariable (name = "id") Integer id, @RequestBody Product newproduct ) {
		Product product = productService.findById(id).map(ct -> {
		ct.setName(newproduct.getName());
		ct.setPrice(newproduct.getPrice());
		ct.setImage(newproduct.getImage());		
		ct.setDescription(newproduct.getDescription());
		return productService.save(ct);		}).get();
		
		return product;
	}
	
	@GetMapping("/{id}/get")
	public Product get(@PathVariable(name="id") Integer id) {
		Product product = productService.findById(id).orElseThrow(() -> new ProductNotFoundException());
		return product;
	}
	
	@GetMapping("/{id}/del")
	public void delete(@PathVariable(name="id") Integer id) {
		productService.deleteById(id);
	}
}
