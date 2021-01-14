package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserService userService;
	@Override
	public User save(User entity) {
		return userService.save(entity);
	}
	@Override
	public List<User> saveAll(List<User> entities) {
		return (List<User>) userService.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userService.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userService.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userService.findAll();
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		return (List<User>) userService.findAllById(ids);
	}

	@Override
	public int count() {
		return userService.count();
	}

	@Override
	public List<User> findByNameLikeOrderByName(String name) {
		return userService.findByNameLikeOrderByName("%" +name+ "%");
	}

	@Override
	public void deleteById(Integer id) {
		userService.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userService.delete(entity);
	}

	@Override
	public void deleteAll(List<User> entities) {
		userService.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userService.deleteAll();
	}
	
	
}
