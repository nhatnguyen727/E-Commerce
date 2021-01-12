package com.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Models.Orders;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("")
	public void insert (@RequestBody Orders order) {
		orderService.save(order);
	}
	
	@GetMapping("")
	public List<Orders> list(){
		return (List<Orders>) orderService.findAll();
	}
	
	
}
