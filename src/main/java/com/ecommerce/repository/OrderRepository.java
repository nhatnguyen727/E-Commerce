package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

	Iterable<Order> findByUser(User user);

}
