package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderDetail;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;

@RestController
public class OrderController {

	private OrderRepository orderRepo;
	private OrderDetailRepository detailRepo;
	private UserRepository userRepo;

	@Autowired
	public OrderController(OrderRepository orderRepo, OrderDetailRepository detailRepo, UserRepository userRepo) {
		this.orderRepo = orderRepo;
		this.detailRepo = detailRepo;
		this.userRepo = userRepo;
	}

	@GetMapping("/admin/order")
	public Iterable<Order> list() {
		return orderRepo.findAll();
	}

	@GetMapping("/order/{id}")
	public Optional<Order> getById(@PathVariable("id") int id) {
		return orderRepo.findById(id);
	}

	@PostMapping("/order")
	public ResponseEntity<String> insert(@Valid @RequestBody Order order, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(), HttpStatus.FORBIDDEN);
		}
		orderRepo.save(order);
		return null;
	}

	@PutMapping("/admin/order/{id}")
	public ResponseEntity<Order> update(@PathVariable("id") int id, @RequestBody Order order) {
		if (orderRepo.existsById(id) && id == order.getId()) {
			orderRepo.save(order);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/order/{id}")
	public ResponseEntity<Order> delete(@PathVariable("id") int id) {
		if (orderRepo.existsById(id)) {
			Iterable<OrderDetail> details = detailRepo.findByOrder(orderRepo.findById(id).get());
			detailRepo.deleteAll(details);
			orderRepo.deleteById(id);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/order/user={id}")
	public Iterable<Order> getByUser(@PathVariable("id") int id) {
		if (userRepo.existsById(id)) {
			return orderRepo.findByUser(userRepo.findById(id).get());
		} else {
			return new ArrayList<>();
		}
	}

}
