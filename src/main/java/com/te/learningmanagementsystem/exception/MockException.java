package com.te.learningmanagementsystem.exception;
public class MockException extends RuntimeException{
	String message;
	public MockException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}