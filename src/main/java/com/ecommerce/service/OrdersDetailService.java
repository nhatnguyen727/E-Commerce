package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.OrdersDetail;

public interface OrdersDetailService {

	List<OrdersDetail> findAllById(Iterable<Integer> ids);

	Iterable<OrdersDetail> findAll();

	Optional<OrdersDetail> findById(Integer id);

	OrdersDetail save(OrdersDetail entity);

}
