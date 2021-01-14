package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.Role;
import com.ecommerce.Models.Topping;
import com.ecommerce.repositories.RoleRepository;
import com.ecommerce.repositories.ToppingRepository;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired 
	RoleRepository roleRepository;
	
	@Override
	public Role save(Role entity) {
		return roleRepository.save(entity);
	}
	@Override
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	} 
	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}
	@Override
	public List<Role> findAllById(Iterable<Integer> ids) {
		return (List<Role>) roleRepository.findAllById(ids);
	}
	

}
