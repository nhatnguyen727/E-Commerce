package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.Models.Orders;

public interface OrderService {

	void deleteAll();

	void deleteAll(List<Orders> entities);

	void delete(Orders entity);

	void deleteById(Integer id);

	int count();


	Iterable<Orders> findAll();

	boolean existsById(Integer id);

	Optional<Orders> findById(Integer id);

	List<Orders> saveAll(List<Orders> entities);

	Orders save(Orders entity);

	List<Orders> findAllById(Iterable<Integer> ids);

	


}
