package com.te.allerganlms.controller;

import java.io.File;
import java.io.OutputStream;

//import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.allerganlms.entity.Asset;
import com.te.allerganlms.entity.Status;
import com.te.allerganlms.response.LmsResponse;
import com.te.allerganlms.serviceImplementation.AssetServiceImp;

@RestController
@RequestMapping("/ASSET")
public class AssetController {
	@Autowired
	private AssetServiceImp assetServiceImp;


	@PostMapping("/ADDASSET")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> createAsset(@RequestParam("file") MultipartFile file) {
//		ObjectMapper mapper=new ObjectMapper();
//		Asset readValue = mapper.readValue(dto, Asset.class);
		Integer asset = assetServiceImp.createAsset(file);
		LmsResponse lmsResponse = LmsResponse.builder().data(asset).error(false).message("Asset added successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@GetMapping("/GETASSET/K/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> getAsset(@PathVariable Integer courseId) {

		 OutputStream asset = assetServiceImp.getAsset(courseId);
		
//		restTemplate.execute(null, null, null, null, null)
		LmsResponse lmsResponse = LmsResponse.builder().data(asset).error(false).message("Asset fetched successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);

	}

	@PutMapping("/UPDATEASSETDATA/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> updateAssetData(@PathVariable Integer courseId,
			@RequestParam("file") MultipartFile file) throws Exception {
		File files = assetServiceImp.updateAssetData(courseId, file);

		LmsResponse lmsResponse = LmsResponse.builder().data(files).error(false)
				.message("Asset Data updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEASSETNAME/{courseName}/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> updateAssetName(@PathVariable Integer courseId,
			@PathVariable String courseName) {
		Asset asset = assetServiceImp.updateAssetName(courseId, courseName);
		LmsResponse lmsResponse = LmsResponse.builder().data(asset).error(false)
				.message("Asset Name updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEASSETSTATUS/{status}/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> updateAssetStatus(@PathVariable Integer courseId, Status status) {
		Asset asset = assetServiceImp.updateAssetStatus(courseId, status);
		LmsResponse lmsResponse = LmsResponse.builder().data(asset).error(false)
				.message("Asset Status updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.ACCEPTED);
	}

	@PutMapping("/UPDATEASSETQUIZ/{courseId}/{quizId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> updateAssetQuiz(@PathVariable Integer courseId) {
		Asset asset = assetServiceImp.updateAssetQuiz(courseId);
		LmsResponse lmsResponse = LmsResponse.builder().data(asset).error(false)
				.message("Asset Quiz updated successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@DeleteMapping("/DELETEASSET/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> deleteAsset(@PathVariable Integer courseId) {
		assetServiceImp.deleteAsset(courseId);
		LmsResponse lmsResponse = LmsResponse.builder().error(false).message("Asset deleted successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PostMapping("/SETGROUP/{groupId}/{courseId}")
//	@PreAuthorize(value = "hasRole('ADMIN')")
	public ResponseEntity<LmsResponse> setGroup(@PathVariable Integer groupId, @PathVariable Integer courseId) {
		File file = assetServiceImp.setGroup(groupId, courseId);
		LmsResponse lmsResponse = LmsResponse.builder().data(file).error(false)
				.message("Asset set to a group successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}
//	 @PostMapping("/withoutAttachment")
//		public ResponseEntity<LmsResponse> sendEmail(@RequestBody MessageDetails messageDetails) throws MessagingException {
//			String attachment = emailService.sendSimpleEmail(messageDetails);
//			LmsResponse lmsResponse = LmsResponse.builder().message(attachment).error(false).message("mail sent successfully").build();
//			return new ResponseEntity<>(lmsResponse,HttpStatus.ACCEPTED);
//			
//
//		}

}
