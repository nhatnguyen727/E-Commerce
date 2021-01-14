package com.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Models.Category;
import com.ecommerce.Models.Role;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public List<Role> list() {
	    return (List<Role>)roleService.findAll();
	}
	@PostMapping("")
	public void insert(@RequestBody Role role) {
		roleService.save(role);
	}
	@GetMapping("/{id}")
	public Optional<Role> get(@PathVariable(name="id") Integer id) {
		Optional<Role> role = roleService.findById(id);
		return role;
	}
}
