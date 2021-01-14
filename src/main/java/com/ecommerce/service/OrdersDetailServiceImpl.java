package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.OrdersDetail;
import com.ecommerce.repositories.OrdersDetailRepository;
@Service
public class OrdersDetailServiceImpl implements OrdersDetailService{
	@Autowired 
	OrdersDetailRepository detailRepository;
	
	@Override
	public OrdersDetail save(OrdersDetail entity) {
		return detailRepository.save(entity);
	}
	@Override
	public Optional<OrdersDetail> findById(Integer id) {
		return detailRepository.findById(id);
	} 
	@Override
	public Iterable<OrdersDetail> findAll() {
		return detailRepository.findAll();
	}
	@Override
	public List<OrdersDetail> findAllById(Iterable<Integer> ids) {
		return (List<OrdersDetail>) detailRepository.findAllById(ids);
	}

}
