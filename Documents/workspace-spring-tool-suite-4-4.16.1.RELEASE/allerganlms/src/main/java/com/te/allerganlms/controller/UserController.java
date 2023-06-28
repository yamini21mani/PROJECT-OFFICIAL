package com.te.allerganlms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.allerganlms.dto.LoginDto;
import com.te.allerganlms.dto.RolesDto;
import com.te.allerganlms.dto.UserCreationDto;
import com.te.allerganlms.entity.Roles;
import com.te.allerganlms.entity.User;
import com.te.allerganlms.entity.UserJourney;
import com.te.allerganlms.entity.UserStatus;
import com.te.allerganlms.response.LmsResponse;
import com.te.allerganlms.serviceImplementation.UserJourneyServiceImp;
import com.te.allerganlms.serviceImplementation.UserServiceImp;

@RestController
@RequestMapping("/USER")
public class UserController {
	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private UserJourneyServiceImp userJourneyServiceImp;

//CREATE API's
//	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/CREATEADMINUSER/{groupId}")
	public ResponseEntity<LmsResponse> createAdminUser(@PathVariable Integer groupId,
			@RequestBody UserCreationDto userCreationDto) {
		System.err.println("request inside create admin user");
		String createQuiz = userServiceImp.createAdminUser(groupId, userCreationDto);
		LmsResponse lmsResponse = LmsResponse.builder().data(createQuiz).error(false).message("User added successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/CREATECOMMONUSER//{groupId}")
	public ResponseEntity<LmsResponse> createCommonUser(@PathVariable Integer groupId,
			@RequestBody UserCreationDto userCreationDto) {
		Integer createQuiz = userServiceImp.createCommonUser(groupId, userCreationDto);
		LmsResponse lmsResponse = LmsResponse.builder().data(createQuiz).error(false).message("User added successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	// FETCH API
//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@GetMapping("/GETUSER/{employeeId}")
	public ResponseEntity<LmsResponse> getUser(@PathVariable Integer employeeId) {
		User group = userServiceImp.getUser(employeeId);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("User fetched successfully")
				.build();
		
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//ADMIN update API's
//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@PutMapping("/UPDATEUSER/EMPLOYEENAME/{employeeId}/{employeeName}")
	public ResponseEntity<LmsResponse> updateAdminEmployeeName(@PathVariable Integer employeeId,
			@PathVariable String employeeName) {
		User group = userServiceImp.updateEmployeeName(employeeId, employeeName);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("User name updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@PutMapping("/UPDATEUSER/EMPLOYEEPASSWORD/{employeeId}/{employeePassword}")
	public ResponseEntity<LmsResponse> updateEmployeePassword(@PathVariable Integer employeeId,
			@PathVariable String employeePassword) {
		User group = userServiceImp.updateEmployeePassword(employeeId, employeePassword);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("User password updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//USER UPDATE API's
//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@PutMapping("/UPDATEUSER/STATUS/{employeeId}/{status}")
	public ResponseEntity<LmsResponse> updateUserStatus(@PathVariable Integer employeeId,
			@PathVariable UserStatus status) {
		User group = userServiceImp.updateUserStatus(employeeId, status);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("User status updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@DeleteMapping("/DELETEUSER/{employeeId}")
	public ResponseEntity<LmsResponse> deleteUser(@PathVariable Integer employeeId) {
		userServiceImp.deleteUser(employeeId);
		LmsResponse lmsResponse = LmsResponse.builder().data("No data available").error(false)
				.message("User data deleted successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

//	@PreAuthorize(value = "hasRole('ADMIN','USER')")
	@GetMapping("/GETUSERJOURNEY/{employeeId}")
	public ResponseEntity<LmsResponse> getUserJourney(@PathVariable Integer employeeId) {
		UserJourney group = userJourneyServiceImp.getUserJourney(employeeId);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("User Journey Fetched successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);

	}

	@PostMapping("/LOGIN")
//	@PreAuthorize(value = "hasAnyRole('ADMIN','USER')")
	public ResponseEntity<LmsResponse> login(@RequestBody LoginDto loginDto) {
		UserDetails loadUserByUsername = userServiceImp.loadUserByUsername(loginDto.getEmployeeUserName());
		LmsResponse lmsResponse = LmsResponse.builder().message("Successfully authenticated").data(loadUserByUsername)
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PostMapping("/CREATEROLE")
//	@PreAuthorize(value = "hasAnyRole('ADMIN')")
	public ResponseEntity<LmsResponse> createRole(@RequestBody RolesDto rolesDto) {
		Roles loadUserByUsername = userServiceImp.createRole(rolesDto);
		LmsResponse lmsResponse = LmsResponse.builder().message("Successfully Role Created").data(loadUserByUsername)
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PostMapping("/DELETEROLE/{roleId}")
	@PreAuthorize(value = "hasAnyRole('ADMIN')")
	public ResponseEntity<LmsResponse> deleteRole(@PathVariable Integer roleId) {
		Roles loadUserByUsername = userServiceImp.deleteRole(roleId);
		LmsResponse lmsResponse = LmsResponse.builder().message("Successfully Deleted Role").data(loadUserByUsername)
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

}
