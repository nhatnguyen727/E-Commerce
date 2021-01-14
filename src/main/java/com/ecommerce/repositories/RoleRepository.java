package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
