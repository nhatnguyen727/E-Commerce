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

import com.ecommerce.Models.User;
import com.ecommerce.exception.UserNotFoundException;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired 
	UserService userService;
	
	@PostMapping("")
	public void insert(@RequestBody User user) {
		userService.save(user);
	}
	
	@GetMapping("")
	public List<User> list(){
		return (List<User>) userService.findAll();
	}
	
	@PutMapping("/{id}/upd")
	public User update(@PathVariable (name = "id") Integer id, @RequestBody User newUser) {
		User user = userService.findById(id).map(u ->{
			u.setPhone(newUser.getPhone());
			u.setAddress(newUser.getAddress());
			u.setBirthday(newUser.getBirthday());
			u.setFullname(newUser.getFullname());
			u.setPassword(newUser.getPassword());
			u.setPhoto(newUser.getPhoto());
			u.setUsername(newUser.getUsername());
			u.setUserstaus(newUser.getUserstaus());
			u.setIdRole(newUser.getIdRole());
			return userService.save(u);
		}).get();
		return user;
		
	}
	
	@GetMapping("/{id}/get")
	public User get(@PathVariable (name ="id") Integer id) {
		User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException());
		return user;
	}
	
	@GetMapping("/{id}/del")
	public void delete(@PathVariable (name="id") Integer id) {
		userService.deleteById(id);
	}
}
