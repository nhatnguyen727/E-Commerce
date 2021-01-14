package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.User;
import com.ecommerce.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;
	@Override
	public User save(User entity) {
		return repository.save(entity);
	}
	@Override
	public List<User> saveAll(List<User> entities) {
		return (List<User>) repository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		return (List<User>) repository.findAllById(ids);
	}

	@Override
	public int count() {
		return (int) repository.count();
	}

	

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAll(List<User> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	
	
}
