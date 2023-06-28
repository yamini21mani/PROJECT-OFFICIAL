package com.te.allerganlms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.allerganlms.dto.GroupRolesCreationDto;
import com.te.allerganlms.entity.GroupRoles;
import com.te.allerganlms.entity.GroupStatus;
import com.te.allerganlms.response.LmsResponse;
import com.te.allerganlms.serviceImplementation.GroupServiceImp;

@RestController
@RequestMapping("/GROUP")
//@PreAuthorize(value = "hasRole('ADMIN')")
public class GroupController {
	@Autowired
	private GroupServiceImp groupServiceImp;

	@PostMapping("/ADDGROUP")
	public ResponseEntity<LmsResponse> createGroup(@RequestBody GroupRolesCreationDto groupRolesDto) {
		Integer group = groupServiceImp.createGroup(groupRolesDto);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Group added successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@GetMapping("/GETGROUP/{groupId}")
	public ResponseEntity<LmsResponse> getGroup(@PathVariable Integer groupId) {
		GroupRoles group = groupServiceImp.getGroup(groupId);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Group fetched successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEGROUP/{groupId}/{groupName}")
	public ResponseEntity<LmsResponse> updateGroupName(@PathVariable Integer groupId, @PathVariable String groupName) {
		GroupRoles group = groupServiceImp.updateGroupName(groupId, groupName);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("Group Name updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEGROUP/{groupId}/{groupStatus}")
	public ResponseEntity<LmsResponse> updateGroupStatus(@PathVariable Integer groupId,
			@PathVariable GroupStatus groupStatus) {
		GroupRoles group = groupServiceImp.updateGroupStatus(groupId, groupStatus);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("Group Status updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEGROUP/{groupId}/{groupRole}")
	public ResponseEntity<LmsResponse> updateGroupRole(@PathVariable Integer groupId, @PathVariable String groupRole) {
		GroupRoles group = groupServiceImp.updateGroupRole(groupId, groupRole);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false)
				.message("Group Role updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@DeleteMapping("/DELETEGROUP/{groupId}")
	public ResponseEntity<LmsResponse> deleteGroup(@PathVariable Integer groupId) {
		groupServiceImp.deleteGroup(groupId);
		LmsResponse lmsResponse = LmsResponse.builder().error(false).message("Group deleted successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}
//	 @PostMapping("/withoutAttachment")
//		public ResponseEntity<EcommerceResponse> sendEmail(@RequestBody MessageDetails messageDetails) throws MessagingException {
//			String attachment = emailService.sendSimpleEmail(messageDetails);
//			ecommerceResponse.setData(attachment);
//			ecommerceResponse.setStatus("200");
//			ecommerceResponse.setMessage("mail sent successfully");
//			ecommerceResponse.setError(false);
//			return new ResponseEntity<>(ecommerceResponse,HttpStatus.ACCEPTED);
//			
//
//		}
}
