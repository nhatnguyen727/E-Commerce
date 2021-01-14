package com.ecommerce.exception;

public class OrDetailNotFoundException extends RuntimeException{

	public OrDetailNotFoundException() {
		super("Order detail not found exception");
		// TODO Auto-generated constructor stub
	}

	public OrDetailNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OrDetailNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrDetailNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrDetailNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
