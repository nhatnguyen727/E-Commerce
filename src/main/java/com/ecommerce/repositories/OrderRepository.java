package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
