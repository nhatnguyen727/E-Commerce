package com.ecommerce.security;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.model.Role;
import com.ecommerce.model.User;

public class RegistrationFormat {

	private Integer id;

	@NotNull // @Pattern does NOT check null value
	@Pattern(regexp = "^"

			+ "\\w+([-.]\\w+)*@"

			+ "\\w+([-.]\\w+)*\\."

			+ "\\w+([-.]\\w+)*"

			+ "$",

			message = "must be in the following format: email@example.com")
	private String email;

	@NotNull
	@Pattern(regexp = "^"

			+ "(?=.{4,20}$)"// at least 4-20 characters long

			+ "[a-zA-Z0-9._]+" // characters, underscore and dot are allowed

			+ "$",

			message = "must be 4 to 20 chars, only alphanumeric chars, underscores and dots are allowed.")
	private String username;

	@Pattern(regexp = "^(?=\\S+$).{4,}$", message = "must be at least 4 chars, whitespace is not allowed.")
	private String password;

	@NotNull
	private String fullname;

	@NotNull
	private String address;

	@NotNull
	@Pattern(regexp = "^[0-9]{10,11}$", message = "must be 10 to 11 digits.")
	private String phone;

	private Role role;

	private boolean newPassword = true;

	private boolean admin = false;

	public User toUser(PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setFullname(fullname);
		user.setAddress(address);
		user.setPhone(phone);
		if (!admin) {
			Role role = new Role();
			role.setId(2);
			user.setRole(role);
		} else {
			user.setRole(role);
		}
		if (newPassword) {
			user.setPassword(passwordEncoder.encode(password));
		} else {
			user.setPassword(password);
		}
		user.setDeleted(false);
		return user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isNewPassword() {
		return newPassword;
	}

	public void setNewPassword(boolean newPassword) {
		this.newPassword = newPassword;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
