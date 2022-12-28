package com.te.learningmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learningmanagementsystem.dto.AdminShowRequestDto;
import com.te.learningmanagementsystem.dto.BatchDetailsDto;
//import com.te.learningmanagementsystem.dto.BatchDetailsDto;
import com.te.learningmanagementsystem.entity.RequestApproval;
import com.te.learningmanagementsystem.dto.EmployeeDto;
import com.te.learningmanagementsystem.dto.MentorDeleteDto;
import com.te.learningmanagementsystem.dto.MentorListDto;
import com.te.learningmanagementsystem.dto.MentorUpdateDto;
import com.te.learningmanagementsystem.dto.PrimaryInfoDto;
import com.te.learningmanagementsystem.dto.RequestListForEmployee;
import com.te.learningmanagementsystem.dto.StatusDto;
import com.te.learningmanagementsystem.entity.BatchDetails;
import com.te.learningmanagementsystem.entity.Mentor;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.exception.NoRecordFoundException;
import com.te.learningmanagementsystem.response.LmsResponse;
import com.te.learningmanagementsystem.service.EmployeeServiceImp;
//import com.te.springboot.dto.EmployeeBatchDetailDto;
//import com.te.springboot.entity.EmployeeBatchDetails;


@RequestMapping(path = "/AdminController")
@RestController
public class AdminController {
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	@Autowired
	private LmsResponse lmsResponse;

	@DeleteMapping("/deleteEmployeedata")
	public ResponseEntity<LmsResponse> deleteEmployeedata(@RequestBody EmployeeDto employeeDto) {
		String employeedata = employeeServiceImp.deleteEmployeedata(employeeDto);
		if (employeedata == null) {
			lmsResponse.setMessage("Data deleted successfully");
			lmsResponse.setStatus("200");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else {
			 throw new NoRecordFoundException();
		}

	}
//Admin approve
		@PostMapping("/approve")
		public ResponseEntity<LmsResponse> approveBatch(@RequestBody AdminShowRequestDto adminShowRequestDto) {

			//ArrayList<StatusDto> demoDto = employeeServiceImp.approve(batchDetails);
			ArrayList<StatusDto> demoDto = employeeServiceImp.approve();
			
			employeeServiceImp.approveStoring(adminShowRequestDto);
			if (demoDto == null) {
				lmsResponse.setMessage("Data approve");
				lmsResponse.setStatus("200");
				lmsResponse.setData(demoDto);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);

			}
			throw new NoRecordFoundException();
		}

//Admin reject
		@PostMapping("/reject")
		public ResponseEntity<LmsResponse> rejectBatch(@RequestBody StatusDto dto) {
			 StatusDto dto2 = employeeServiceImp.reject(dto);
			lmsResponse.setMessage("Data not  approved");
			lmsResponse.setData(dto2);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);

		}

// request for admin
		@GetMapping("/show request")
		public ResponseEntity<LmsResponse> requestAdmin() {
			List<RequestListForEmployee> forEmployees = employeeServiceImp.employeeRequest();
			if (forEmployees != null) {
				lmsResponse.setMessage("show req successfull");
				lmsResponse.setStatus("200");
				lmsResponse.setData(forEmployees);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);

			}

			throw new NoRecordFoundException();
		}
//Get Data API
		@GetMapping("/getdata")
		public ResponseEntity<LmsResponse> getDetails(PrimaryInfoDto employeeDto){
			PrimaryInfo employeedata = employeeServiceImp.getEmployeedata(employeeDto);
			if (employeedata == null) {
				lmsResponse.setMessage("Data fetched successfully");
				lmsResponse.setStatus("200");
				lmsResponse.setData(employeedata);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} else {
				throw new NoRecordFoundException();
			}
		}
		
		@GetMapping("/searchBatch")
	public ResponseEntity<LmsResponse> searchBatchDetails(@RequestBody BatchDetailsDto batchDetailDto) {
		BatchDetails searchbatch = employeeServiceImp.searchBatchDetails(batchDetailDto);
			if (searchbatch == null) {
				lmsResponse.setMessage("Batch created successfully");
				lmsResponse.setStatus("200");
				lmsResponse.setData(searchbatch);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} else {
				lmsResponse.setMessage("Invalid Entry");
				lmsResponse.setStatus("500");
				lmsResponse.setData(null);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);

			}
		}
		
		@PutMapping("/creatementor")
		public ResponseEntity<LmsResponse> getCreate(@RequestBody MentorListDto list) {

			Mentor list2 = employeeServiceImp.createMentorList(list);
			if (list2 != null) {

				lmsResponse.setMessage("sucess");
				lmsResponse.setStatus("200");
				lmsResponse.setError(false);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
			}
			throw new NoRecordFoundException();
		}
		
		
		@PutMapping("/updatementor")
		public ResponseEntity<LmsResponse> getUpdate(@RequestBody MentorUpdateDto dto) {
		
			Mentor list= employeeServiceImp.createMentorUpdate(dto);
			if(list != null) {
				lmsResponse.setMessage("sucess");
				lmsResponse.setStatus("200");
				lmsResponse.setError(false);
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
			}
			throw new NoRecordFoundException();
			
		}
		
		@DeleteMapping("/deletementor")
		public ResponseEntity<LmsResponse> getDelete(@RequestBody MentorDeleteDto deleteDto){
			
		boolean input	= employeeServiceImp.createMentorDelete(deleteDto);
		if(input) {
			lmsResponse.setMessage("sucess");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		throw new NoRecordFoundException();
		
	}
		// BatchDetails API
		@PostMapping("/createBatch")
		public ResponseEntity<LmsResponse> createBatchDetails(@RequestBody BatchDetails batchDetails) {
			BatchDetails createbatch = employeeServiceImp.createBatchDetails(batchDetails);
			if (createbatch == null) {
				lmsResponse.setMessage("Batch created successfully");
				lmsResponse.setStatus("200");
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} throw new NoRecordFoundException();
		}

		@GetMapping("/getBatchlist")
		public ResponseEntity<LmsResponse>getBatchList(@RequestBody BatchDetails batchDetails){
			List<BatchDetails> batchList = employeeServiceImp.getBatchList(batchDetails);
			if(batchList!=null) {
				lmsResponse.setMessage("BatchList retrieved Successfully");
				lmsResponse.setStatus("200");
				return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
			}
			throw new NoRecordFoundException();
			
		}
		@GetMapping("/getBatch")
		public ResponseEntity<LmsResponse> getBatchDetails(@RequestBody BatchDetailsDto batchDetailDto) {
			BatchDetails getbatch = employeeServiceImp.getBatchDetails(batchDetailDto);
			if (getbatch == null) {
				lmsResponse.setMessage("Batch retrieved successfully");
				lmsResponse.setStatus("200");
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} throw new NoRecordFoundException();
		}

		@PutMapping("/updateBatch")
		public ResponseEntity<LmsResponse> updateBatchDetails(@RequestBody BatchDetailsDto batchDetailDto) {
			BatchDetails updatebatch = employeeServiceImp.updateBatchDetails(batchDetailDto);
			if (updatebatch == null) {
				lmsResponse.setMessage("Batch updated successfully");
				lmsResponse.setStatus("200");
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} throw new NoRecordFoundException();
		}

		@DeleteMapping("/deleteBatch")
		public ResponseEntity<LmsResponse> deleteBatchDetails(@RequestBody BatchDetailsDto batchDetailDto) {
			String deletebatch = employeeServiceImp.deleteBatchDetails(batchDetailDto);
			if (deletebatch == null) {
				lmsResponse.setMessage("Batch deleted successfully");
				lmsResponse.setStatus("200");
				return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
			} throw new NoRecordFoundException();
		}

}
