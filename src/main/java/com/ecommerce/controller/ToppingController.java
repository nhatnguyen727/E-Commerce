package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Topping;
import com.ecommerce.repository.ToppingRepository;

@RestController
@RequestMapping("/admin/topping")
public class ToppingController {

	@Autowired
	private ToppingRepository toppingRepo;

	@GetMapping
	public Iterable<Topping> list() {
		return toppingRepo.findAll();
	}

}
