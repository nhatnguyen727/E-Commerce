package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Models.Orders;
import com.ecommerce.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public  Orders save(Orders entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<Orders> saveAll(List<Orders> entities) {
		return (List<Orders>) orderRepository.saveAll(entities);
	}

	@Override
	public Optional<Orders> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Iterable<Orders> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public List<Orders> findAllById(Iterable<Integer> ids) {
		return (List<Orders>) orderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Orders entity) {
		orderRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Orders> entities) {
		orderRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	
}
