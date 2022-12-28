package com.te.learningmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learningmanagementsystem.dto.AddressDto;
import com.te.learningmanagementsystem.dto.BankDetailsDto;
import com.te.learningmanagementsystem.dto.ContactDto;
import com.te.learningmanagementsystem.dto.EducationalDetailsDto;
import com.te.learningmanagementsystem.dto.ExperienceDto;
import com.te.learningmanagementsystem.dto.PrimaryInfoDto;
import com.te.learningmanagementsystem.dto.SecondaryInfoDto;
import com.te.learningmanagementsystem.dto.TechnicalDto;
import com.te.learningmanagementsystem.entity.AddressInfo;
import com.te.learningmanagementsystem.entity.BankDetails;
import com.te.learningmanagementsystem.entity.ContactInfo;
import com.te.learningmanagementsystem.entity.EducationalDetails;
import com.te.learningmanagementsystem.entity.ExperienceInfo;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.entity.SecondaryInfo;
import com.te.learningmanagementsystem.entity.TechnicalInfo;
import com.te.learningmanagementsystem.exception.DeleteException;
import com.te.learningmanagementsystem.response.LmsResponse;
import com.te.learningmanagementsystem.service.EmployeeServiceImp;

@RequestMapping(path = "/Employee")
@RestController
public class EmployeeController {
	@Autowired
	private LmsResponse lmsResponse;
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	
	
	@PutMapping("/primaryInfoUpdate")
	public ResponseEntity<LmsResponse> getPrimaryInfoUpdate(@RequestBody PrimaryInfoDto employeeUpdateDto) {
		PrimaryInfo primaryInfo = employeeServiceImp.update(employeeUpdateDto);
		if (primaryInfo != null) {
			lmsResponse.setMessage("sucess");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucesss");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeSecondaryInfoUpdate")
	public ResponseEntity<LmsResponse> getUpdate(@RequestBody SecondaryInfoDto infoUpdate) {
		SecondaryInfo infoUpdate2 = employeeServiceImp.secondaryInfoUpdate(infoUpdate);
		if (infoUpdate2 != null) {
			lmsResponse.setMessage("success");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeAddressUpdate")
	public ResponseEntity<LmsResponse> getAddressUpdate(@RequestBody AddressDto addressUpdate) {
		AddressInfo employeeAddressInfo = employeeServiceImp.addressUpdate(addressUpdate);
		if (employeeAddressInfo != null) {
			lmsResponse.setMessage("success");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeBankUpdate")
	public ResponseEntity<LmsResponse> getBankUpdate(@RequestBody BankDetailsDto bankDetailsUpdate) {
		BankDetails employeeBankInfo = employeeServiceImp.bankUpdate(bankDetailsUpdate);
		if (employeeBankInfo != null) {
			lmsResponse.setMessage("success");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsuccess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeecontactUpdate")
	public ResponseEntity<LmsResponse> getContactUpdate(@RequestBody ContactDto contactUpdate) {
		ContactInfo employeecontactInfo = employeeServiceImp.contactUpdate(contactUpdate);
		if (employeecontactInfo != null) {
			lmsResponse.setMessage("sucess");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeEducationUpdate")
	public ResponseEntity<LmsResponse> getEducationUpdate(@RequestBody EducationalDetailsDto educationUpdate) {
		EducationalDetails employeeEducationInfo = employeeServiceImp.educationupdate(educationUpdate);
		if (employeeEducationInfo != null) {
			lmsResponse.setMessage("success");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeTechnicalUpdate")

	public ResponseEntity<LmsResponse> getTechnicalUpdate(@RequestBody TechnicalDto infoUpdate) {
		TechnicalInfo info = employeeServiceImp.technicalUpdate(infoUpdate);
		if (info != null) {

			lmsResponse.setMessage("success");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsuccess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/employeeExperienceUpdate")

	public ResponseEntity<LmsResponse> getExperienceUpdate(@RequestBody ExperienceDto infoUpdate) {
		ExperienceInfo info = employeeServiceImp.getExperienceUpdate(infoUpdate);
		if (info != null) {

			lmsResponse.setMessage("sucess");
			lmsResponse.setStatus("200");
			lmsResponse.setError(false);
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
		}
		lmsResponse.setMessage("unsucess");
		lmsResponse.setStatus("404");
		lmsResponse.setError(true);
		return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.OK);
	}
	
	// delete 


	@DeleteMapping("/deleteAddress")
	public ResponseEntity<LmsResponse> deleteAddressdata( @RequestBody AddressDto addressDto) {
		String deletedata = employeeServiceImp.deleteAddress(addressDto);
		if (deletedata == null) {
			lmsResponse.setMessage("Data deleted successfully");
			lmsResponse.setStatus("200");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else {
			throw new DeleteException("Address not deleted");

		}
	}

	@DeleteMapping("/deleteExperience")
	public ResponseEntity<LmsResponse> deleteExperienceDetails(ExperienceDto experienceDto) {
		String deletedata = employeeServiceImp.deleteExperience(experienceDto);
		if (deletedata == null) {
			lmsResponse.setMessage("Data deleted successfully");
			lmsResponse.setStatus("200");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else {
			throw new DeleteException("Experience not deleted");

		}
	}

	@DeleteMapping("/deleteTechnical")
	public ResponseEntity<LmsResponse> deleteTechnicalDetails(TechnicalDto technicalDto) {
		String deletedata = employeeServiceImp.deleteTechnical(technicalDto);
		if (deletedata == null) {
			lmsResponse.setMessage("Data deleted successfully");
			lmsResponse.setStatus("200");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} else {
			throw new DeleteException(" not deleted");
		}
	}

	@DeleteMapping("/deleteContact")
	public ResponseEntity<LmsResponse> deleteContactDetails(ContactDto contactDto) {
		String deletedata = employeeServiceImp.deleteContact(contactDto);
		if (deletedata == null) {
			lmsResponse.setMessage("Data deleted successfully");
			lmsResponse.setStatus("200");
			return new ResponseEntity<LmsResponse>(lmsResponse, HttpStatus.ACCEPTED);
		} throw new DeleteException(" not deleted");
	}
//	@DeleteMapping("/deleteAddress")
//	public ResponseEntity<LmsResponse> deleteAddress(@RequestBody AddressDto addressDto){
//		String deleteData=employeeServiceImp.deleteAddress(addressDto);
//		if (deleteData == null) {
//			lmsResponse.setMessage("Data Deleted Successfully");
//			lmsResponse.setStatus("200");
//			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
//			
//		}else {
//			throw new DeleteException(" not deleted");
//		}
//	
//		
//	}
//	@DeleteMapping("/deleteExperience")
//	public ResponseEntity<LmsResponse> deleteExperience(@RequestBody ExperienceDto experienceDto){
//		String deleteData=employeeServiceImp.deleteExperience(experienceDto);
//		if (deleteData== null) {
//			lmsResponse.setMessage("Data  Deleted");
//			lmsResponse.setStatus("200");
//			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
//			
//		}else {
//			throw new DeleteException(" not deleted");
//		}	
//	}
//	
//	@DeleteMapping("/deleteContact")
//	public ResponseEntity<LmsResponse> deleteContact(@RequestBody ContactDto contactDto){
//		String deleteData=employeeServiceImp.deleteContact(contactDto);
//		if (deleteData== null) {
//			lmsResponse.setMessage("Data  Deleted");
//			lmsResponse.setStatus("200");
//			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
//			
//		}else {
//			throw new DeleteException(" not deleted");
//		}
//	}
//	@DeleteMapping("/deleteTechnical")
//	public ResponseEntity<LmsResponse> deleteTechnical(@RequestBody TechnicalDto technicalDto){
//		String deleteData=employeeServiceImp.deleteTechnical(technicalDto);
//		if (deleteData== null) {
//			lmsResponse.setMessage("Data  Deleted");
//			lmsResponse.setStatus("200");
//			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
//			
//		}else {
//			throw new DeleteException(" not deleted");
//		}
//	}
	

}
