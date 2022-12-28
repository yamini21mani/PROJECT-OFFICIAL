package com.te.learningmanagementsystem.serviceInterface;

import java.util.ArrayList;
import java.util.List;

import com.te.learningmanagementsystem.dto.AddressDto;
import com.te.learningmanagementsystem.dto.AdminShowRequestDto;
import com.te.learningmanagementsystem.dto.BankDetailsDto;
import com.te.learningmanagementsystem.dto.BatchDetailsDto;
import com.te.learningmanagementsystem.dto.ContactDto;
import com.te.learningmanagementsystem.entity.Employee;
import com.te.learningmanagementsystem.entity.EmployeelistInBatch;
import com.te.learningmanagementsystem.dto.EducationalDetailsDto;
import com.te.learningmanagementsystem.dto.EmployeeDto;
import com.te.learningmanagementsystem.dto.ExperienceDto;
import com.te.learningmanagementsystem.dto.MentorDeleteDto;
import com.te.learningmanagementsystem.dto.MentorListDto;
import com.te.learningmanagementsystem.dto.MentorUpdateDto;
import com.te.learningmanagementsystem.dto.MockDetailsDto;
import com.te.learningmanagementsystem.dto.MockInfoDto;
import com.te.learningmanagementsystem.dto.PasswordChecking;
import com.te.learningmanagementsystem.dto.PrimaryInfoDto;
import com.te.learningmanagementsystem.dto.RequestListForEmployee;
import com.te.learningmanagementsystem.dto.SecondaryInfoDto;
import com.te.learningmanagementsystem.dto.StatusDto;
import com.te.learningmanagementsystem.dto.TechnicalDto;
import com.te.learningmanagementsystem.entity.AddressInfo;
import com.te.learningmanagementsystem.entity.BankDetails;
import com.te.learningmanagementsystem.entity.BatchDetails;
import com.te.learningmanagementsystem.entity.ContactInfo;
import com.te.learningmanagementsystem.entity.EducationalDetails;
import com.te.learningmanagementsystem.entity.Employee;
import com.te.learningmanagementsystem.entity.ExperienceInfo;

import com.te.learningmanagementsystem.entity.Mentor;
import com.te.learningmanagementsystem.entity.Mock;
import com.te.learningmanagementsystem.entity.MockRatings;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.entity.SecondaryInfo;
import com.te.learningmanagementsystem.entity.TechnicalInfo;

public interface EmployeeService {
//Employee Delete API's
	public String deleteAddress(AddressDto addressDto);
	public String deleteExperience(ExperienceDto experienceDto);
	public String deleteContact(ContactDto contactDto);
	public String deleteTechnical(TechnicalDto technicalDto);	
//Mock DATA API's
//	public boolean createMockData(MockDetailsDto mockDetailsDto);
	public boolean createMockData(MockDetailsDto mockDetailsDto);
	public Mock getMockDetails(MockDetailsDto mockDetailsDto);
	public Mock updateMockDetails(MockDetailsDto mockDetailsDto);
	public String deleteMockDetails(MockDetailsDto mockDetailsDto);
//Mock INFO API's
	public boolean createMockInfo(MockRatings mockRatings);
	public MockRatings getMockInfo(MockInfoDto mockInfoDto);
	public MockRatings updateMockInfo(MockInfoDto mockInfoDto);
	public String deleteMockInfo(MockInfoDto mockInfoDto);
// update API's
	public PrimaryInfo update(PrimaryInfoDto employeeUpdateDto);
	public SecondaryInfo secondaryInfoUpdate(SecondaryInfoDto infoUpdate);
	public AddressInfo addressUpdate(AddressDto addressUpdate);
	public BankDetails bankUpdate(BankDetailsDto bankDetailsUpdate);
	public ContactInfo contactUpdate(ContactDto contactUpdate);
	public EducationalDetails educationupdate(EducationalDetailsDto educationUpdate);
	public TechnicalInfo technicalUpdate(TechnicalDto infoUpdate);
	public ExperienceInfo getExperienceUpdate(ExperienceDto infoUpdate);	
//register API
	public PrimaryInfo register(PrimaryInfo primary_Info2);	
//Get API's
	public PrimaryInfo getEmployeedata(PrimaryInfoDto employeeDto);
//Delete API	
	public String deleteEmployeedata(EmployeeDto employeeDto); 
//Admin approval API's
	//public void showReq();
	public List<RequestListForEmployee> employeeRequest();
	public ArrayList<StatusDto> approve();
	public void approveStoring(AdminShowRequestDto adminShowRequestDto);
	public StatusDto reject(StatusDto dto);
	public Employee showRequest(EmployeelistInBatch demoDtoForMentor);
//Employee first time login
	PrimaryInfo firstReset(PasswordChecking passwordChecking);
//Login API
	public PrimaryInfo login(EmployeeDto employeeDto); 

//Mentor list
		public Mentor createMentorList(MentorListDto list);
		public Mentor createMentorUpdate(MentorUpdateDto dto);	
		public boolean createMentorDelete(MentorDeleteDto deleteDto);
		public BatchDetails searchBatchDetails(BatchDetailsDto batchDetailDto);
//batch details API
		public BatchDetails createBatchDetails(BatchDetails batchDetails);
		public BatchDetails getBatchDetails(BatchDetailsDto batchDetailDto);
		public BatchDetails updateBatchDetails(BatchDetailsDto batchDetailDto);
		public String deleteBatchDetails(BatchDetailsDto batchDetailDto);
		
		public List<BatchDetails> getBatchList(BatchDetails batchDetails);
//		public String deleteBatchDetails(BatchDetailsDto batchDetailDto);
//		public Batch_Details getBatchDetails(BatchDetailsDto batchDetailDto);
//		public Batch_Details updateBatchDetails(BatchDetailsDto batchDetailDto);
//		public Batch_Details createBatchDetails(Batch_Details batchDetails) ;
}
