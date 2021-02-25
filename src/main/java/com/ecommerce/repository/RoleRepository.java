package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	boolean existsByName(String name);

}
