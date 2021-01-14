package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repositories.OrdDetailToppingRepository;
import com.ecommerce.Models.OrDetailTopping;
@Service
public class OrDetailToppingServiceImpl implements OrDetailToppingService {
	@Autowired
	OrdDetailToppingRepository ordDetailToppingRepository;

	@Override
	public  OrDetailTopping save(OrDetailTopping entity) {
		return ordDetailToppingRepository.save(entity);
	}

	@Override
	public  List<OrDetailTopping> saveAll(List<OrDetailTopping> entities) {
		return (List<OrDetailTopping>) ordDetailToppingRepository.saveAll(entities);
	}

	@Override
	public Optional<OrDetailTopping> findById(Integer id) {
		return ordDetailToppingRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ordDetailToppingRepository.existsById(id);
	}

	@Override
	public Iterable<OrDetailTopping> findAll() {
		return ordDetailToppingRepository.findAll();
	}

	@Override
	public List<OrDetailTopping> findAllById(Iterable<Integer> ids) {
		return (List<OrDetailTopping>) ordDetailToppingRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return ordDetailToppingRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		ordDetailToppingRepository.deleteById(id);
	}

	@Override
	public void delete(OrDetailTopping entity) {
		ordDetailToppingRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends OrDetailTopping> entities) {
		ordDetailToppingRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordDetailToppingRepository.deleteAll();
	}

	
	
}
