package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.OrdersDetail;
import com.ecommerce.repositories.OrdDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrdDetailService{
	@Autowired
	OrdDetailRepository ordDetailRepository;

	@Override
	public OrdersDetail save(OrdersDetail entity) {
		return ordDetailRepository.save(entity);
	}

	@Override
	public List<OrdersDetail> saveAll(Iterable<OrdersDetail> entities) {
		return (List<OrdersDetail>) ordDetailRepository.saveAll(entities);
	}

	@Override
	public Optional<OrdersDetail> findById(Integer id) {
		return ordDetailRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ordDetailRepository.existsById(id);
	}

	@Override
	public Iterable<OrdersDetail> findAll() {
		return ordDetailRepository.findAll();
	}

	@Override
	public List<OrdersDetail> findAllById(Iterable<Integer> ids) {
		return (List<OrdersDetail>) ordDetailRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return ordDetailRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		ordDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OrdersDetail entity) {
		ordDetailRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<OrdersDetail> entities) {
		ordDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordDetailRepository.deleteAll();
	}

	
}
