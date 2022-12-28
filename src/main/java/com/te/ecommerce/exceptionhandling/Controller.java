package com.te.ecommerce.exceptionhandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecommerce.response.EcommerceResponse;

@ControllerAdvice
public class Controller {
	@Autowired
	EcommerceResponse ecommerceResponse;

	@ExceptionHandler(CredentialsException.class)
	public ResponseEntity<EcommerceResponse> credentialException(CredentialsException credentialsException) {
		ecommerceResponse.setMessage(credentialsException.getMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<EcommerceResponse> ProductException(ProductException productException) {
		ecommerceResponse.setMessage(productException.getMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<EcommerceResponse> GeneralException(GeneralException generalException) {
		ecommerceResponse.setMessage(generalException.getMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
}
