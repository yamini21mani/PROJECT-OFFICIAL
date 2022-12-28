package com.te.learningmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.learningmanagementsystem.dto.EmployeeDto;
import com.te.learningmanagementsystem.dto.PasswordChecking;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.exception.NoRecordFoundException;
import com.te.learningmanagementsystem.response.LmsResponse;
import com.te.learningmanagementsystem.service.EmployeeServiceImp;

@RestController
public class BaseController {

	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	@Autowired
	private LmsResponse lmsResponse;
	
	@PostMapping("/login")
	public ResponseEntity<LmsResponse> login(@RequestBody EmployeeDto employeeDto) {
		if (employeeDto.getEmpId().startsWith("TYA")) {
			PrimaryInfo info = employeeServiceImp.login(employeeDto);
			if (info != null) {
				lmsResponse.setMessage("Loggedin successfully");
				lmsResponse.setStatus("200");
				lmsResponse.setData(info);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			}
		}
		
		else if (employeeDto.getEmpId().startsWith("TYM")) {
			PrimaryInfo info = employeeServiceImp.login(employeeDto);
			if (info != null) {
				lmsResponse.setMessage("Loggedin successfully");
				lmsResponse.setStatus("200");
				lmsResponse.setData(info);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			}

		} 
		
		else if (employeeDto.getEmpId().startsWith("TYE")) {
			PrimaryInfo info = employeeServiceImp.login(employeeDto);
			if (info != null) {
				lmsResponse.setMessage("Loggedin successfully");
				lmsResponse.setStatus("200");
				lmsResponse.setData(info);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			}
		}	

		else {
			lmsResponse.setMessage("Invalid credentials");
			lmsResponse.setStatus("404");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);

		}
		return null;
	}
//	//Registration API
//		@PostMapping("/register")
//		public ResponseEntity<LmsResponse> register(@RequestBody Primary_Info primary_Info) {
//			Primary_Info register = employeeServiceImp.register(primary_Info);
//			if (register != null) {
//				lmsResponse.setMessage("Thanks for registeration, you will receive an email from Admin once approved...");
//				lmsResponse.setData(register);
//				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
//			}else {
//				lmsResponse.setMessage("failed");
//				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
//			}
//			
//		}
//For first time
	@PostMapping("/firstlogin")
	ResponseEntity<LmsResponse> firstTimeReset(@RequestBody PasswordChecking passwordChecking){
		PrimaryInfo firstReset = employeeServiceImp.firstReset(passwordChecking);
		if(firstReset!=null) {
			
			lmsResponse.setMessage("log in sucessful");
			lmsResponse.setStatus("200");
			lmsResponse.setData(firstReset);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
		} else {
			
			throw new NoRecordFoundException();
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<LmsResponse> register(@RequestBody PrimaryInfo primaryInfo) {
		PrimaryInfo register = employeeServiceImp.register(primaryInfo);
		if (register != null) {
			lmsResponse.setMessage("Thanks for registeration");
			lmsResponse.setData(primaryInfo);
			lmsResponse.setStatus("false");
			lmsResponse.setStatus("200");
			
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.CREATED);
		}else {
			throw new NoRecordFoundException();
		}
		
	}
}
