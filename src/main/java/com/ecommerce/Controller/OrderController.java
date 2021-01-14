package com.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Models.Orders;
import com.ecommerce.exception.OrderNotFoundException;
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
	
	@PutMapping("/{id}/upd")
	public Orders Orders(@PathVariable (name ="id") Integer id, @RequestBody Orders newOrder ) {
		Orders order = orderService.findById(id).map(ord ->{
			ord.setOrderAdress(newOrder.getOrderAdress());
			ord.setOrderDate(newOrder.getOrderDate());
			ord.setOrderStatus(newOrder.getOrderStatus());
			ord.setOrderToName(newOrder.getOrderToName());
			ord.setPhone(newOrder.getPhone());
			ord.setIdUser(newOrder.getIdUser());
			return orderService.save(ord);
		}).get();
		return order;
	}
	@GetMapping("/{id}/get")
	public Orders get(@PathVariable (name = "id") Integer id) {
		Orders orders = orderService.findById(id).orElseThrow(() -> new OrderNotFoundException());
		return orders;
	}
	@GetMapping("/{id}/del")
	public void delete(@PathVariable (name = "id") Integer id) {
		orderService.deleteById(id);
	}
	
}
