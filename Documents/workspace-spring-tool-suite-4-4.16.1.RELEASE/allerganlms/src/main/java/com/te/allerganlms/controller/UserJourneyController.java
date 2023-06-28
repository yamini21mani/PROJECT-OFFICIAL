//package com.te.allerganlms.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.te.allerganlms.dto.UserUpdateDto;
//import com.te.allerganlms.entity.User;
//import com.te.allerganlms.response.LmsResponse;
//import com.te.allerganlms.serviceImplementation.UserJourneyServiceImp;
//
//@RestController
//@RequestMapping("/USERJOURNEY")
//public class UserJourneyController {
//
//	UserJourneyServiceImp userJourneyServiceImp;
//
//	@PutMapping("/UPDATECOMMONUSER/{employeeId}")
//	public ResponseEntity<LmsResponse> updateCommonUser(@PathVariable Integer employeeId,
//			@RequestBody UserUpdateDto userUpdateDto) {
//		User group = userJourneyServiceImp.updateCommonUser(employeeId, userUpdateDto);
//		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("User updated successfully")
//				.build();
//		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/DELETEUSER/{employeeId}")
//	public ResponseEntity<LmsResponse> deleteUser(@PathVariable Integer employeeId) {
//		userJourneyServiceImp.deleteUser(employeeId);
//		LmsResponse lmsResponse = LmsResponse.builder().data("No data available").error(false)
//				.message("User deleted successfully").build();
//		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
//	}
//
//}
