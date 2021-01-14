package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.OrDetailTopping;

public interface OrDetailToppingService {

	List<OrDetailTopping> findAllById(Iterable<Integer> ids);

	Iterable<OrDetailTopping> findAll();

	Optional<OrDetailTopping> findById(Integer id);

	OrDetailTopping save(OrDetailTopping entity);
	
}
