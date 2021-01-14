package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.Role;
import com.ecommerce.Models.Size;
import com.ecommerce.repositories.RoleRepository;
import com.ecommerce.repositories.SizeRepository;
@Service
public class SizeServiceImpl implements SizeService{
	@Autowired 
	SizeRepository sizeRepository;
	
	@Override
	public Size save(Size entity) {
		return sizeRepository.save(entity);
	}
	@Override
	public Optional<Size> findById(Integer id) {
		return sizeRepository.findById(id);
	} 
	@Override
	public Iterable<Size> findAll() {
		return sizeRepository.findAll();
	}
	@Override
	public List<Size> findAllById(Iterable<Integer> ids) {
		return (List<Size>) sizeRepository.findAllById(ids);
	}
}
