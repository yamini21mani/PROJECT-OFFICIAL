package com.te.onlineTestPortal.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<JreExceptionResponse> customException(@RequestParam String message) {
		JreExceptionResponse response = JreExceptionResponse.builder().message(message).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
