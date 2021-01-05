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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.Models.Product;
import com.ecommerce.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("product", new Product());
		return "products/add";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Product product) {
		String message = "New product inserted!";
		if ( product.getId() > 0) {
			message = "The product update!";
		}

		productService.save(product);
		model.addAttribute(product);
		model.addAttribute("message", message);
		return "products/saveOrUpdate";
	}

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Integer id) {
		Optional<Product> optProduct = productService.findById(id);
		if (optProduct.isPresent()) {
			model.addAttribute("products", optProduct.get());
		} else {
			return list(model);
		}

		return "products/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
		productService.deleteById(id);
		return list(model);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Product> list = (List<Product>) productService.findAll();
		model.addAttribute("products", list);
		return "list";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam String name) {
		List<Product> list = productService.findByNameLikeOrderByName(name);
		model.addAttribute("product", list);
		return "find";
	}
}
