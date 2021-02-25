package com.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.RegistrationFormat;

@RestController
public class UserController {

	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/admin/user")
	public Iterable<User> list() {
		return userRepo.findByDeletedFalse();
	}

	@PostMapping("/user/register")
	public ResponseEntity<String> insert(@Valid @RequestBody RegistrationFormat regModel, Errors errors) {
		if (userRepo.existsByUsername(regModel.getUsername())) {
			return new ResponseEntity<>("username already exists!", HttpStatus.CONFLICT);
		}
		if (errors.hasErrors()) {
			return new ResponseEntity<>(
					errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
					HttpStatus.FORBIDDEN);
		}
		userRepo.save(regModel.toUser(passwordEncoder));
		return null;
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @Valid @RequestBody RegistrationFormat regModel,
			Errors errors) {
		if (userRepo.existsById(id) && id == regModel.getId()) {
			if (userRepo.existsByUsername(regModel.getUsername())) {
				if (userRepo.findByUsername(regModel.getUsername()).getId() != id) {
					return new ResponseEntity<>("username already exists!", HttpStatus.CONFLICT);
				}
			}
			if (regModel.getPassword() == null) {
				regModel.setPassword(userRepo.findById(id).get().getPassword());
				regModel.setNewPassword(false);
			}
			if (errors.hasErrors()) {
				return new ResponseEntity<>(
						errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
						HttpStatus.FORBIDDEN);
			}
			User user = regModel.toUser(passwordEncoder);
			user.setId(id);
			userRepo.save(user);
			return null;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping("admin/user/register")
	public ResponseEntity<String> adminInsert(@Valid @RequestBody RegistrationFormat regModel, Errors errors) {
		if (userRepo.existsByUsername(regModel.getUsername())) {
			return new ResponseEntity<>("username already exists!", HttpStatus.CONFLICT);
		}
		if (errors.hasErrors()) {
			return new ResponseEntity<>(
					errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
					HttpStatus.FORBIDDEN);
		}
		regModel.setAdmin(true);
		userRepo.save(regModel.toUser(passwordEncoder));
		return null;
	}

	@PutMapping("admin/user/{id}")
	public ResponseEntity<String> adminUpdate(@PathVariable("id") int id,
			@Valid @RequestBody RegistrationFormat regModel, Errors errors) {
		if (userRepo.existsById(id) && id == regModel.getId()) {
			if (userRepo.existsByUsername(regModel.getUsername())) {
				if (userRepo.findByUsername(regModel.getUsername()).getId() != id) {
					return new ResponseEntity<>("username already exists!", HttpStatus.CONFLICT);
				}
			}
			if (regModel.getPassword() == null) {
				regModel.setPassword(userRepo.findById(id).get().getPassword());
				regModel.setNewPassword(false);
			}
			if (errors.hasErrors()) {
				return new ResponseEntity<>(
						errors.getFieldError().getField() + " " + errors.getFieldError().getDefaultMessage(),
						HttpStatus.FORBIDDEN);
			}
			regModel.setAdmin(true);
			User user = regModel.toUser(passwordEncoder);
			user.setId(id);
			userRepo.save(user);
			return null;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/admin/user/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") int id) {
		if (userRepo.existsById(id)) {
			User user = userRepo.findById(id).get();
			user.setDeleted(true);
			userRepo.save(user);
			return null;
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user/username={username}")
	public ResponseEntity<User> getByUsername(@PathVariable("username") String username) {
		if (userRepo.existsByUsername(username)) {
			return new ResponseEntity<>(userRepo.findByUsername(username), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user/email={email}")
	public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
		if (userRepo.existsByEmail(email)) {
			return new ResponseEntity<>(userRepo.findByEmail(email), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
