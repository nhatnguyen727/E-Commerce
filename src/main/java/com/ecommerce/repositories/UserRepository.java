package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ecommerce.Models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	
	
}
