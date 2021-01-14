package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.Models.User;

public interface UserService {

	void deleteAll(List<User> entities);

	void delete(User entity);

	void deleteById(Integer id);

	List<User> findByNameLikeOrderByName(String name);

	int count();

	List<User> findAllById(Iterable<Integer> ids);

	Iterable<User> findAll();

	boolean existsById(Integer id);

	Optional<User> findById(Integer id);

	List<User> saveAll(List<User> entities);

	User save(User entity);

	void deleteAll();

}
