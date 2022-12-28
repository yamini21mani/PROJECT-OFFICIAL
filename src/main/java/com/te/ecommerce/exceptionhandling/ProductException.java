package com.te.ecommerce.exceptionhandling;
@SuppressWarnings("serial")
public class ProductException extends RuntimeException{
	String message;

	public ProductException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
