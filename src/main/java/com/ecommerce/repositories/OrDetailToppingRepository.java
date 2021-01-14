package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.OrDetailTopping;

@Repository
public interface OrDetailToppingRepository extends CrudRepository<OrDetailTopping, Integer> {

}
