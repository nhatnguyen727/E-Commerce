package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.Models.OrDetailTopping;
import com.ecommerce.repositories.OrDetailToppingRepository;

public class OrDetailToppingServiceImpl implements OrDetailToppingService{
	@Autowired 
	OrDetailToppingRepository detailToppingRepository;
	
	@Override
	public OrDetailTopping save(OrDetailTopping entity) {
		return detailToppingRepository.save(entity);
	}
	@Override
	public Optional<OrDetailTopping> findById(Integer id) {
		return detailToppingRepository.findById(id);
	} 
	@Override
	public Iterable<OrDetailTopping> findAll() {
		return detailToppingRepository.findAll();
	}
	@Override
	public List<OrDetailTopping> findAllById(Iterable<Integer> ids) {
		return (List<OrDetailTopping>) detailToppingRepository.findAllById(ids);
	}
}
