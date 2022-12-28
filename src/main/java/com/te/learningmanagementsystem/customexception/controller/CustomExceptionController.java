package com.te.learningmanagementsystem.customexception.controller;

import java.io.InvalidClassException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.learningmanagementsystem.exception.DeleteException;
import com.te.learningmanagementsystem.exception.InvalidId;
import com.te.learningmanagementsystem.exception.MockException;
import com.te.learningmanagementsystem.exception.NoRecordFoundException;
import com.te.learningmanagementsystem.exception.WrongPassWord;
import com.te.learningmanagementsystem.response.LmsResponse;

@ControllerAdvice
public class CustomExceptionController {
	
	@Autowired
	LmsResponse lmsResponse;
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<LmsResponse> exception(InvalidId exception){
		
		lmsResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<LmsResponse> handleNoRecordFoundException(NoRecordFoundException noRecordFoundException) {
		lmsResponse.setData(null);
		lmsResponse.setMessage("No Record Found");
		lmsResponse.setStatus("400");
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(WrongPassWord.class)
	public ResponseEntity<LmsResponse> handleWrongPassWord(WrongPassWord wrongPassWord) {
		lmsResponse.setMessage("Wrong Employee PassWord");

		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DeleteException.class)
	public ResponseEntity<LmsResponse> handleWrongPassWord(DeleteException deleteException) {
		
		lmsResponse.setMessage(deleteException.getMessage());

		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MockException.class)
	public ResponseEntity<LmsResponse> handleMockException(MockException mockException) {
		
		lmsResponse.setMessage(mockException.getMessage());

		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}
	
	

}
