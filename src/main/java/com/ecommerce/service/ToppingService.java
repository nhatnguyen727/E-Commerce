package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.Topping;

public interface ToppingService {

	Topping save(Topping entity);

	Optional<Topping> findById(Integer id);

	Iterable<Topping> findAll();

	List<Topping> findAllById(Iterable<Integer> ids);

	

}
