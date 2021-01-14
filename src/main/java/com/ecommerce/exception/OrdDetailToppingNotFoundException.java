package com.ecommerce.exception;

public class OrdDetailToppingNotFoundException extends RuntimeException{

	public OrdDetailToppingNotFoundException() {
		super("Order Detail Toppinng not found exception");
		// TODO Auto-generated constructor stub
	}

	public OrdDetailToppingNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OrdDetailToppingNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrdDetailToppingNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrdDetailToppingNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
