package com.te.learningmanagementsystem.exception;
public class DeleteException extends RuntimeException {
	String message;
	public DeleteException(String message){
		//super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	

}