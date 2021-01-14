package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.Models.OrdersDetail;


public interface OrdDetailService {

	void deleteAll();

	void deleteAll(List<OrdersDetail> entities);

	void delete(OrdersDetail entity);

	void deleteById(Integer id);

	long count();

	List<OrdersDetail> findAllById(Iterable<Integer> ids);

	Iterable<OrdersDetail> findAll();

	boolean existsById(Integer id);

	Optional<OrdersDetail> findById(Integer id);

	List<OrdersDetail> saveAll(Iterable<OrdersDetail> entities);

	OrdersDetail save(OrdersDetail entity);

}
