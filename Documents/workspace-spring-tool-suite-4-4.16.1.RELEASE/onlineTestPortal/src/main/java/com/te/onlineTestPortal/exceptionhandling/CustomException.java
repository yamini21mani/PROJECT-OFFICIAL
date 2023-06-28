package com.te.onlineTestPortal.exceptionhandling;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class CustomException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public CustomException(String message) {
		super();
		this.message = message;
	}

}
