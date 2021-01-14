package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.Models.Topping;
import com.ecommerce.repositories.ToppingRepository;

public class ToppingServiceImpl implements ToppingService{
	
	@Autowired 
	ToppingRepository toppingRepository;
	
	@Override
	public Topping save(Topping entity) {
		return toppingRepository.save(entity);
	}
	@Override
	public Optional<Topping> findById(Integer id) {
		return toppingRepository.findById(id);
	} 
	@Override
	public Iterable<Topping> findAll() {
		return toppingRepository.findAll();
	}
	@Override
	public List<Topping> findAllById(Iterable<Integer> ids) {
		return (List<Topping>) toppingRepository.findAllById(ids);
	}

}
