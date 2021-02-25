package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.OrderDetail;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;

@RestController
public class OrderDetailController {

	private OrderDetailRepository detailRepo;
	private OrderRepository orderRepo;

	@Autowired
	public OrderDetailController(OrderDetailRepository detailRepo, OrderRepository orderRepo) {
		this.detailRepo = detailRepo;
		this.orderRepo = orderRepo;
	}

	@GetMapping("/detail")
	public Iterable<OrderDetail> list() {
		return detailRepo.findAll();
	}

	@GetMapping("/detail/{id}")
	public Optional<OrderDetail> getById(@PathVariable("id") int id) {
		return detailRepo.findById(id);
	}

	@PutMapping("/admin/detail/{id}")
	public ResponseEntity<OrderDetail> update(@PathVariable("id") int id, @RequestBody OrderDetail detail) {
		if (detailRepo.existsById(id) && id == detail.getId()) {
			detailRepo.save(detail);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/detail/{id}")
	public ResponseEntity<OrderDetail> delete(@PathVariable("id") int id) {
		if (detailRepo.existsById(id)) {
			detailRepo.deleteById(id);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/detail/order={id}")
	public Iterable<OrderDetail> getByOrder(@PathVariable("id") int id) {
		if (orderRepo.existsById(id)) {
			return detailRepo.findByOrder(orderRepo.findById(id).get());
		} else {
			return new ArrayList<>();
		}
	}

}
