package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Models.Role;
import java.util.Optional;

public interface RoleService {

	List<Role> findAllById(Iterable<Integer> ids);

	Iterable<Role> findAll();

	Optional<Role> findById(Integer id);

	Role save(Role entity);


}
