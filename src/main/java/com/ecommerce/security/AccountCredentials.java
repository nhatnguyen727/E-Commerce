package com.ecommerce.security;

public class AccountCredentials {

	private String username;

	private String password;

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

}

/**
 * This class keeps credentials for authentication. It doesn't have the @Entity annotation because we don't have to save
 * credentials to the database
 */
