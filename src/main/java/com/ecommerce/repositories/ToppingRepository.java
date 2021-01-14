package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Topping;

@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer>{

}
