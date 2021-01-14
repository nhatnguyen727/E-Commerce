package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.OrDetailTopping;

public interface OrDetailToppingService {

	void deleteAll();

	void deleteAll(Iterable<? extends OrDetailTopping> entities);

	void delete(OrDetailTopping entity);

	void deleteById(Integer id);

	long count();

	List<OrDetailTopping> findAllById(Iterable<Integer> ids);

	Iterable<OrDetailTopping> findAll();

	boolean existsById(Integer id);

	Optional<OrDetailTopping> findById(Integer id);

	List<OrDetailTopping> saveAll(List<OrDetailTopping> entities);

	OrDetailTopping save(OrDetailTopping entity);

}
