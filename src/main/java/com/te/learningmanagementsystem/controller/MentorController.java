package com.te.learningmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.learningmanagementsystem.entity.EmployeelistInBatch;
import com.te.learningmanagementsystem.dto.MockDetailsDto;
import com.te.learningmanagementsystem.dto.MockInfoDto;
import com.te.learningmanagementsystem.entity.Employee;
import com.te.learningmanagementsystem.entity.Mock;
import com.te.learningmanagementsystem.entity.MockRatings;
import com.te.learningmanagementsystem.exception.MockException;
import com.te.learningmanagementsystem.exception.NoRecordFoundException;
import com.te.learningmanagementsystem.response.LmsResponse;
import com.te.learningmanagementsystem.service.EmployeeServiceImp;

@RestController
public class MentorController {
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	@Autowired
	private LmsResponse lmsResponse;
	
	
//CreateMockdetails API
	@PostMapping("/createMockDetails")
	public ResponseEntity<LmsResponse> createMockData( @RequestBody MockDetailsDto mockDetailsDto) {
		boolean addMock = employeeServiceImp.createMockData(mockDetailsDto);
		if (addMock == true) {
			lmsResponse.setMessage("Mock details added successfully");
			lmsResponse.setStatus("200");
//			lmsResponse.set(200);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else { 
	throw new MockException("MockDetails not fetch");
	}
	}
//ReadMockDetails API
	@GetMapping("/getMockDetails")
	public ResponseEntity<LmsResponse> getMockDetails(@RequestBody MockDetailsDto mockDetailsDto){
		Mock readData=employeeServiceImp.getMockDetails(mockDetailsDto);
		if (readData != null) {
			lmsResponse.setMessage(" Data Retrieved Successfully");
//			lmsResponse.setError(200);
			lmsResponse.setData(readData);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
			
		}else { 
			throw new MockException("MockDetails not fetch");
		}
		
	}
//UpdateMockDetails
	@PutMapping("/updateMockDetails")
	public ResponseEntity<LmsResponse> updateMockDetails(@RequestBody MockDetailsDto mockDetailsDto){
		Mock updateData=employeeServiceImp.updateMockDetails(mockDetailsDto);
		if (updateData != null) {
			lmsResponse.setMessage("Data Updated Successfully");
//			lmsResponse.setError(200);
			//lmsResponse.setData(updateData);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
			
		}else { 
			throw new MockException("MockDetails not fetch");
		}
		
	}

		
//DeleteMockdetails API
		@DeleteMapping("/deleteMockDetails")
		public ResponseEntity<LmsResponse> deleteMockDetails(@RequestBody MockDetailsDto mockDetailsDto) {
			String mockDel = employeeServiceImp.deleteMockDetails(mockDetailsDto);
			if (mockDel==null) {
				lmsResponse.setMessage("Mock details deleted successfully");
				lmsResponse.setStatus("200");
				//lmsResponse.setError("No error");
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} else { 
				throw new MockException("MockDetails not fetch");
			}
		}

//CreateMockInfo API
		@PostMapping("/createMockInfo")
		public ResponseEntity<LmsResponse> createMockInfo( @RequestBody MockRatings mockRatings) {
			boolean addMock = employeeServiceImp.createMockInfo(mockRatings);
			if (addMock == true) {
				lmsResponse.setMessage("Mock details added successfully");
				lmsResponse.setStatus("200");
//				lmsResponse.setError(200);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} else { 
				throw new MockException("MockDetails not fetch");
			}
		}
//ReadMockdInfo API
	@GetMapping("/getMockInfo")
	public ResponseEntity<LmsResponse> getMockInfo(@RequestBody MockInfoDto mockInfoDto ){
		MockRatings readData=employeeServiceImp.getMockInfo(mockInfoDto);
		if (readData != null) {
			lmsResponse.setMessage(" Data Retrieved Successfully");
			lmsResponse.setStatus("200");
			lmsResponse.setData(readData);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
			
		}else { 
			throw new MockException("MockDetails not fetch");
		}

     }
//UpdateMockdInfo API
	@PutMapping("/updateMockInfo")
	public ResponseEntity<LmsResponse> updateMockInfo(@RequestBody MockInfoDto mockInfoDto){
		MockRatings updateData=employeeServiceImp.updateMockInfo(mockInfoDto);
		if (updateData != null) {
			lmsResponse.setMessage("Data Updated Successfully");
			lmsResponse.setStatus("200");
			//lmsResponse.setData(updateData);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
			
		}else { 
			throw new MockException("MockDetails not fetch");
		}
    }
	
	//DeleteMockdInfo API
	@DeleteMapping("/deleteMockInfo")
	public ResponseEntity<LmsResponse> deleteMockInfo(@RequestBody MockInfoDto mockInfoDto) {
		String mockDel = employeeServiceImp.deleteMockInfo(mockInfoDto);
		if (mockDel==null) {
			lmsResponse.setMessage("Mock details deleted successfully");
			lmsResponse.setStatus("200");
			//lmsResponse.setError("No error");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else { 
			throw new MockException("MockDetails not fetch");
		}
	}
	@PostMapping("/show batch")
	public  ResponseEntity<LmsResponse> request(@RequestBody EmployeelistInBatch demoDtoForMentor) {
		Employee Mentor = employeeServiceImp.showRequest( demoDtoForMentor);
		if (Mentor!=null) {
			lmsResponse.setMessage("show batch success");
			lmsResponse.setStatus("200");
			lmsResponse.setData(Mentor);
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
		}
		throw new NoRecordFoundException();
	}
}
