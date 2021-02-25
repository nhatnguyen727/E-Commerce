package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Topping;

@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer> {

}
