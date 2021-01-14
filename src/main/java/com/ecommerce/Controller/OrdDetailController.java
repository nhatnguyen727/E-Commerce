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

import com.ecommerce.Models.OrdersDetail;
import com.ecommerce.exception.OrDetailNotFoundException;
import com.ecommerce.service.OrdDetailService;

@RestController
@RequestMapping("/OrdDetail")
public class OrdDetailController {
	@Autowired
	private OrdDetailService ordDetailService;

	@PostMapping("")
	public void insert(@RequestBody OrdersDetail ordDetail) {
		ordDetailService.save(ordDetail);
	}

	@GetMapping("")
	public List<OrdersDetail> list() {
		return (List<OrdersDetail>) ordDetailService.findAll();
	}
	
	@PutMapping("/{id}/upd")
	public OrdersDetail ordDetail(@PathVariable (name="id") Integer id, @RequestBody OrdersDetail newOrDetail) {
		OrdersDetail orDetail = ordDetailService.findById(id).map(o ->{
			o.setNote(newOrDetail.getNote());
			o.setQuantity(newOrDetail.getQuantity());
			return ordDetailService.save(o);
		}).get();
		return orDetail;
	}
	@GetMapping("/{id}/get")
	public OrdersDetail get(@PathVariable (name ="id") Integer id) {
		OrdersDetail orDetail = ordDetailService.findById(id).orElseThrow(() -> new OrDetailNotFoundException());
		return orDetail;
	}
	@GetMapping("/{id}/del")
	public void delete(@PathVariable (name = "id") Integer id) {
		ordDetailService.deleteById(id);
	}
	
}
