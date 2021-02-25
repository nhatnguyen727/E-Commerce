package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	Iterable<User> findByDeletedFalse();

	User findByUsername(String username);

	User findByEmail(String email);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}
