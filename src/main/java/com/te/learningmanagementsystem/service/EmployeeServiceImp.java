package com.te.learningmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.te.learningmanagementsystem.dto.AddressDto;
import com.te.learningmanagementsystem.dto.AdminShowRequestDto;
import com.te.learningmanagementsystem.dto.BankDetailsDto;
import com.te.learningmanagementsystem.dto.BatchDetailsDto;
import com.te.learningmanagementsystem.dto.ContactDto;
import com.te.learningmanagementsystem.entity.RequestApproval;
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
import com.te.learningmanagementsystem.entity.ApproveListByAdmin;
import com.te.learningmanagementsystem.entity.BankDetails;
import com.te.learningmanagementsystem.entity.BatchDetails;
//import com.te.learningmanagementsystem.entity.Bank_Details;
//import com.te.learningmanagementsystem.entity.Batch_Details;
import com.te.learningmanagementsystem.entity.ContactInfo;
import com.te.learningmanagementsystem.entity.EducationalDetails;
import com.te.learningmanagementsystem.entity.Employee;
//import com.te.learningmanagementsystem.entity.Educational_Details;
import com.te.learningmanagementsystem.entity.ExperienceInfo;

import com.te.learningmanagementsystem.entity.Mentor;
import com.te.learningmanagementsystem.entity.Mock;
import com.te.learningmanagementsystem.entity.MockRatings;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.entity.SecondaryInfo;
//import com.te.learningmanagementsystem.entity.Secondary_Info;
import com.te.learningmanagementsystem.entity.TechnicalInfo;
import com.te.learningmanagementsystem.exception.InvalidId;
import com.te.learningmanagementsystem.passwordgenerator.PasswordGenerator;
import com.te.learningmanagementsystem.repository.AddressRepository;
import com.te.learningmanagementsystem.repository.ApproveRepositary;
import com.te.learningmanagementsystem.repository.BankDetailsRepository;
import com.te.learningmanagementsystem.repository.BatchDetailRepository;
import com.te.learningmanagementsystem.repository.ContactRepository;
import com.te.learningmanagementsystem.repository.EmployeelistRepositary;
import com.te.learningmanagementsystem.repository.RequestApprovalRepository;
import com.te.learningmanagementsystem.repository.EducationalRepository;
import com.te.learningmanagementsystem.repository.ExperienceRepository;
import com.te.learningmanagementsystem.repository.EmployeeRepository;
import com.te.learningmanagementsystem.repository.MentorEntityRepository;
import com.te.learningmanagementsystem.repository.MockDetailRepository;
import com.te.learningmanagementsystem.repository.MockInfoRepository;
import com.te.learningmanagementsystem.repository.PrimaryInfoRepository;
import com.te.learningmanagementsystem.repository.SecondaryRepository;
import com.te.learningmanagementsystem.repository.StatusRepository;
import com.te.learningmanagementsystem.repository.TechnicalRepository;
import com.te.learningmanagementsystem.serviceInterface.EmployeeService;



@Service
public  class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private PasswordChecking passwordChecking;
	// Repository
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Autowired
	private ApproveRepositary approveRepositary;

	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private BatchDetailRepository batchDetailRepository;
	@Autowired
	private RequestApprovalRepository requestApprovalRepository;
	@Autowired
	private EducationalRepository educationalRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	@Autowired
	private TechnicalRepository technicalRepository;
	@Autowired
	private PrimaryInfoRepository primaryInfoRepository;
	@Autowired
	private MockDetailRepository mockDetailRepository;
	@Autowired
	private MockInfoRepository mockInfoRepository;
	@Autowired
	private SecondaryRepository secondaryRepository;
	@Autowired
	private MentorEntityRepository mentorEntityRepository;

	// PasswordCreate
	@Autowired
	private PasswordGenerator passwordGenerator;

	// entity
	@Autowired
	private Employee mentorDisplay;
	
	
//	private DemoDtoForMentor demoDtoForMentor;
	@Autowired
	private RequestApproval demoDto;
	@Autowired
	private EducationalDetails educationalDetails;
	@Autowired
	private MockRatings mockRatings;
	@Autowired
	private Mock mock;
	@Autowired
	private PrimaryInfo primaryInfo;
	@Autowired
	private AddressInfo addressInfo;
	@Autowired
	private ContactInfo contactInfo;
	@Autowired
	private BankDetails bankDetails;
	@Autowired
	private BatchDetails batchDetails;
//	@Autowired
//	private Secondary_Info secondary_Info;
	@Autowired
	private ExperienceInfo experienceInfo;
	@Autowired
	private TechnicalInfo technicalInfo;

//deleteApi
	@Override
	public String deleteAddress(AddressDto addressDto) {
		BeanUtils.copyProperties(addressDto, addressInfo);
		AddressInfo addInfo = addressRepository.findById(addressInfo.getsNo()).orElse(null);
		addressRepository.delete(addInfo);
		return null;
	}

	@Override
	public String deleteExperience(ExperienceDto experienceDto) {
		BeanUtils.copyProperties(experienceDto, experienceInfo);
		ExperienceInfo Expinfo = experienceRepository.findById(experienceDto.getsNo()).orElse(null);
		experienceRepository.delete(Expinfo);
		return null;
	}

	@Override
	public String deleteContact(ContactDto contactDto) {
		BeanUtils.copyProperties(contactDto, contactInfo);
		ContactInfo conInfo = contactRepository.findById(contactInfo.getContactNumber()).orElse(null);
		contactRepository.delete(conInfo);
		return null;
	}

	@Override
	public String deleteTechnical(TechnicalDto technicalDto) {
		BeanUtils.copyProperties(technicalDto, technicalInfo);
		TechnicalInfo techInfo = technicalRepository.findById(technicalInfo.getsNo()).orElse(null);
		technicalRepository.delete(techInfo);
		return null;
	}

	@Override
	public String deleteEmployeedata(EmployeeDto employeeDto) {
		BeanUtils.copyProperties(employeeDto, primaryInfo);
		PrimaryInfo primarytable = primaryInfoRepository.findById(primaryInfo.getEmpId()).orElse(null);
		primaryInfoRepository.delete(primarytable);
		return null;
	}

//Mock Info API's	
	@Override
	public boolean createMockData(MockDetailsDto mockDetailsDto) {
			BeanUtils.copyProperties(mockDetailsDto, mock);
			mock.setMockno(mockDetailsDto.getMockno());
			mock.setSno(mockDetailsDto.getSno());
			mock.setPanel(mockDetailsDto.getPanel());
			mock.setDateAndTime(mockDetailsDto.getDateAndTime());
			mock.setTechnology(mockDetailsDto.getTechnology());
			Mock save = mockDetailRepository.save(mock);
			if (save != null) {
				return true;
			} else
				throw new InvalidId("Mock not created please check your fields");
		
	}


	@Override
	public Mock getMockDetails(MockDetailsDto mockDetailsDto) {
		BeanUtils.copyProperties(mockDetailsDto, mock);
		Mock getDetail = mockDetailRepository.findById(mock.getSno()).orElse(null);

		return getDetail;
	}

	@Override
	public Mock updateMockDetails(MockDetailsDto mockDetailsDto) {
		BeanUtils.copyProperties(mockDetailsDto, mock);
		Mock updateDetail = mockDetailRepository.findById(mock.getSno()).orElse(null);
		if (updateDetail != null) {
			mock.setPanel(mockDetailsDto.getPanel());
			mock.setDateAndTime(mockDetailsDto.getDateAndTime());
			mock.setMockno(mockDetailsDto.getMockno());
			mock.setTechnology(mockDetailsDto.getTechnology());
			mock.setMockRating(mockDetailsDto.getMockRating());
			mockDetailRepository.save(mock);
			return mock;

		}
		throw new InvalidId("Mock details not updated");
	}

	@Override
	public String deleteMockDetails(MockDetailsDto mockDetailsDto) {
		BeanUtils.copyProperties(mockDetailsDto, mock);
		mockDetailRepository.deleteById(mockDetailsDto.getSno());
		return null;
	}

	@Override
	public boolean createMockInfo(MockRatings mockRatings) {
		BeanUtils.copyProperties(mockRatings, mock);
		mockRatings.setMockId(mockRatings.getMockId());
//		mock_Info.setMockType(mockInfoDto.getMockType());
//		mock_Info.setMockTakenBy(mockInfoDto.getMockTakenBy());
//		mock_Info.setPraticalMock(mockInfoDto.getPraticalMock());
//		mock_Info.setTheoriticalMock(mockInfoDto.getTheoriticalMock());
//		mock_Info.setOverallFeedBack(mockInfoDto.getOverallFeedBack());
//		mock_Info.setDetailsFeddBack(mockInfoDto.getDetailsFeddBack());
		MockRatings save = mockInfoRepository.save(mockRatings);
		if (save != null) {
			return true;
		}

		return false;
	}

	@Override
	public MockRatings getMockInfo(MockInfoDto mockInfoDto) {
		BeanUtils.copyProperties(mockInfoDto, mockRatings);
		MockRatings getDetail = mockInfoRepository.findById(mockRatings.getMockId()).orElse(null);

		return getDetail;
	}

	@Override
	public MockRatings updateMockInfo(MockInfoDto mockInfoDto) {
		BeanUtils.copyProperties(mockInfoDto, mockRatings);
		MockRatings updateDetail = mockInfoRepository.findById(mockRatings.getMockId()).orElse(null);
		if (updateDetail != null) {
			mockRatings.setMockType(mockInfoDto.getMockType());
			mockRatings.setMockTakenBy(mockInfoDto.getMockTakenBy());
			mockRatings.setPraticalMock(mockInfoDto.getPraticalMock());
			mockRatings.setTheoriticalMock(mockInfoDto.getTheoriticalMock());
			mockRatings.setOverallFeedBack(mockInfoDto.getOverallFeedBack());
			mockRatings.setDetailsFeddBack(mockInfoDto.getDetailsFeddBack());
			mockInfoRepository.save(mockRatings);
			return mockRatings;
		}
		throw new InvalidId("Mock ratings not updated");

	}

	@Override
	public String deleteMockInfo(MockInfoDto mockInfoDto) {
		BeanUtils.copyProperties(mockInfoDto, mockRatings);
		mockDetailRepository.deleteById(mockInfoDto.getMockId());
		return null;
	}

	@Override
	public PrimaryInfo register(PrimaryInfo primary_Info2) {
		primary_Info2.setEmpPass(passwordGenerator.generateRandomString(6));
		PrimaryInfo save = primaryInfoRepository.save(primary_Info2);
		showReq(primary_Info2);
		return save;

	}

	@Override
	public PrimaryInfo login(EmployeeDto employeeDto) {
		BeanUtils.copyProperties(employeeDto, primaryInfo);
		PrimaryInfo employeedata = primaryInfoRepository.findById(primaryInfo.getEmpId()).orElse(null);
		if (primaryInfo.getEmpId().equalsIgnoreCase(employeedata.getEmpId())) {
			if (primaryInfo.getEmpPass().equals(employeedata.getEmpPass())) {
				return employeedata;
			} else {
				throw new InvalidId("Password mismatch");
			}
		}
		throw new InvalidId("please enter the valid id");
	}

//show request API for Admin
//	@Override
	public void showReq(PrimaryInfo primaryInfo) {

//		Primary_Info primarytable = primaryInfoRepository.findById(primary_Info.getEmpId()).orElse(null);
//		Educational_Details details=educationalRepository.findById(educational_Details.getsNo()).orElse(null);
//		Experience_Info info_Entity2 = experienceRepository.findById(experience_Info.getsNo()).orElse(null);
//		Contact_Info contactInfo1 = contactRepository.findById(contact_Info.getContactNumber()).orElse(null);

		PrimaryInfo primarytable = primaryInfoRepository.findById(primaryInfo.getEmpId()).orElse(null);
		
		List<EducationalDetails> educList = primarytable.getEducList();
		for (EducationalDetails educationalDetails : educList) {
			demoDto.setYop(educationalDetails.getYearOfPassing());
			demoDto.setPercentage(educationalDetails.getPercentage());
		}
		
		List<ExperienceInfo> expList = primarytable.getExpList();
		for (ExperienceInfo experienceInfo : expList) {
			demoDto.setExperience(experienceInfo.getYearOfExperience());
		}
		
		List<ContactInfo> conList = primarytable.getConList();
		for (ContactInfo contactInfo : conList) {
			demoDto.setContactNumber(contactInfo.getContactNumber());
		}
		
		
		demoDto.setEmployeeId(primarytable.getEmpId());

		demoDto.setEmployeeName(primarytable.getEmpName());
		
		

//		demoDto.setYop(details.getYearOfPassing());
//
//		demoDto.setPercentage(details.getPercentage());
//
//		demoDto.setExperience(info_Entity2.getYearOfExperience());
//
//		demoDto.setContactNumber(contactInfo1.getContactNumber());
		
		

		requestApprovalRepository.save(demoDto);

	}

//	@Override
//	public ArrayList<StatusDto> approve(EmployeeBatchDetails batchDetails2) {
//		
//	EmployeeBatchDetails findAll = batchDetailsRepository.findById(batchDetails2.getEmp_batch_id()).orElse(null);
//	ArrayList<StatusDto> arrayList= new ArrayList();
//		ArrayList<StatusDto> dto = new ArrayList();
//		BeanUtils.copyProperties(batchDetails2, dto);
//		return dto;
//
//		
//		
//	}
	
//	public ArrayList<StatusDto> approve(){
//		List<Batch_Details> findAll = batchDetailRepository.findAll();
//		ArrayList<StatusDto> arrayList = new ArrayList<>();
//		for (Batch_Details employee : findAll) {
//			arrayList.add(new StatusDto(employee.getEmpBatchId(), employee.getEmpBatchName()));
//
//		}
//		return arrayList;
//
//	}

// to save the reject msg
	@Override
	public StatusDto reject(StatusDto dto) {

		StatusDto save = statusRepository.findById(dto.getEmpBatchId()).orElse(null);
		return statusRepository.save(save);
	}

//mentor Batch details
	@Override
	public Employee showRequest(EmployeelistInBatch demoDtoForMentor) {
		PrimaryInfo primarytable1 = primaryInfoRepository.findById(primaryInfo.getEmpId()).orElse(null);
		Mock mockDetails2 = mockDetailRepository.findById(mock.getSno()).orElse(null);
		MockRatings mock_Info2 = mockInfoRepository.findById(mockRatings.getMockId()).orElse(null);
		BatchDetails employeeBatchDetails = batchDetailRepository.findById(batchDetails.getEmpBatchId()).orElse(null);

		mentorDisplay.setEmployeeId(primarytable1.getEmpId());
		mentorDisplay.setEmployeeName(primarytable1.getEmpName());
		mentorDisplay.setMockRating(mockDetails2.getMockRating());
		mentorDisplay.setStatus(employeeBatchDetails.getEmpStatus());
		mentorDisplay.setMockTakenBy(mock_Info2.getMockTakenBy());
		employeeRepository.save(mentorDisplay);
		return mentorDisplay;

	}

//	For Login First Check and Login
	@Override
	public PrimaryInfo firstReset(PasswordChecking passwordChecking) {
		if (passwordChecking.getEmpId().startsWith("TYE")) {
			PrimaryInfo employeePrimaryInfo = new PrimaryInfo();
			BeanUtils.copyProperties(passwordChecking, employeePrimaryInfo);
			PrimaryInfo findById = primaryInfoRepository.findById(employeePrimaryInfo.getEmpId()).orElse(null);
			if (findById != null) {
				if (findById.getCount() == 0) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						if (passwordChecking.getFirstPassword().equals(passwordChecking.getSecondPassword())) {
							findById.setEmpPass(passwordChecking.getFirstPassword());
							findById.setCount(1);
							primaryInfoRepository.save(findById);
							return findById;
						}
						throw new InvalidId("password mismatch");

					}
					throw new InvalidId("please enter the valid password");
				} else if (findById.getCount() == 1) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						return findById;
					}
					throw new InvalidId("please enter the valid password");
				}
				return null;
			}
			throw new InvalidId("please enter the valid id");
		} else if (passwordChecking.getEmpId().startsWith("TYM")) {
			PrimaryInfo employeePrimaryInfo = new PrimaryInfo();
			BeanUtils.copyProperties(passwordChecking, employeePrimaryInfo);
			PrimaryInfo findById = primaryInfoRepository.findById(employeePrimaryInfo.getEmpId()).orElse(null);
			if (findById != null) {
				if (findById.getCount() == 0) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						if (passwordChecking.getFirstPassword().equals(passwordChecking.getSecondPassword())) {
							findById.setEmpPass(null);
							findById.setCount(1);
							primaryInfoRepository.save(findById);
							return findById;
						}
						throw new InvalidId("password mismatch");

					}
					throw new InvalidId("please enter the valid password");
				} else if (findById.getCount() == 1) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						return findById;
					}
					throw new InvalidId("please enter the valid password");
				}
				return null;
			}
			throw new InvalidId("please enter the id");

		} else if (passwordChecking.getEmpId().startsWith("TYA")) {

			PrimaryInfo employeePrimaryInfo = new PrimaryInfo();
			BeanUtils.copyProperties(passwordChecking, employeePrimaryInfo);
			PrimaryInfo findById = primaryInfoRepository.findById(employeePrimaryInfo.getEmpId()).orElse(null);
			if (findById != null) {
				if (findById.getCount() == 0) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						if (passwordChecking.getFirstPassword().equals(passwordChecking.getSecondPassword())) {
							findById.setEmpPass("1");
							findById.setCount(1);
							primaryInfoRepository.save(findById);
							return findById;
						}
						throw new InvalidId("password mismatch");

					}
					throw new InvalidId("please enter the valid password");
				} else if (findById.getCount() == 1) {
					if (passwordChecking.getGeneratedPassword().equals(findById.getEmpPass())) {
						return findById;
					}
					throw new InvalidId("please enter the valid password");
				}
				return null;
			}
			throw new InvalidId("please enter the id");

		} 
		throw new InvalidId("please enter the valid user id");
	}
//update API's
	@Override
	public PrimaryInfo update(PrimaryInfoDto employeeUpdateDto) {
		PrimaryInfo info = new PrimaryInfo();
		BeanUtils.copyProperties(employeeUpdateDto, info);
		PrimaryInfo primaryInfo = primaryInfoRepository.findById(employeeUpdateDto.getEmpId()).orElse(null);
		if (primaryInfo != null) {
			primaryInfo.setBloodGroup(employeeUpdateDto.getBloodGroup());
			primaryInfo.setDesignation(employeeUpdateDto.getDesignation());
			primaryInfo.setDob(employeeUpdateDto.getDob());
			primaryInfo.setDoj(employeeUpdateDto.getDoj());
			primaryInfo.setEmpStatus(employeeUpdateDto.getEmpStatus());
			primaryInfo.setEmpName(employeeUpdateDto.getEmpName());
			primaryInfo.setNationality(employeeUpdateDto.getNationality());
			primaryInfo.setEmpPass(employeeUpdateDto.getEmpPass());
			return primaryInfoRepository.save(primaryInfo);

		}
		throw new InvalidId("primary details not updated");
	}

	@Override
	public SecondaryInfo secondaryInfoUpdate(SecondaryInfoDto infoUpdate) {
		SecondaryInfo employeeSecondaryInfo = new SecondaryInfo();
		BeanUtils.copyProperties(infoUpdate, employeeSecondaryInfo);
		SecondaryInfo employeeSecondaryInfo2 = secondaryRepository.findById(infoUpdate.getPanNo()).orElse(null);
		if (employeeSecondaryInfo2 != null) {
			employeeSecondaryInfo2.setPanNo(infoUpdate.getPanNo());
			employeeSecondaryInfo2.setAadharNo(infoUpdate.getAadharNo());
			employeeSecondaryInfo2.setFatherName(infoUpdate.getFatherName());
			employeeSecondaryInfo2.setMaritalStatus(infoUpdate.getMaritalStatus());
			employeeSecondaryInfo2.setMotherName(infoUpdate.getMotherName());
			employeeSecondaryInfo2.setPassportNo(infoUpdate.getPassportNo());
			employeeSecondaryInfo2.setSpouseName(infoUpdate.getSpouseName());

			return secondaryRepository.save(employeeSecondaryInfo2);

		}
		throw new InvalidId("secondary details not updated");
	}

	@Override
	public AddressInfo addressUpdate(AddressDto addressUpdate) {
		AddressInfo addressInfo = new AddressInfo();
		BeanUtils.copyProperties(addressUpdate, addressInfo);
		AddressInfo addressInfo2 = addressRepository.findById(addressUpdate.getsNo()).orElse(null);
		if (addressInfo2 != null) {
			addressInfo2.setAddressType(addressUpdate.getAddressType());
			addressInfo2.setCity(addressUpdate.getCity());
			addressInfo2.setDoorNo(addressUpdate.getDoorNo());
			addressInfo2.setLandMark(addressUpdate.getLandMark());
			addressInfo2.setLocality(addressUpdate.getLocality());
			addressInfo2.setPincode(addressUpdate.getPincode());
			addressInfo2.setStreet(addressUpdate.getStreet());

			return addressRepository.save(addressInfo2);

		}
		throw new InvalidId("address details not updated");
//		return null;
	}

	@Override
	public BankDetails bankUpdate(BankDetailsDto bankDetailsUpdate) {
		BankDetails bankDetails = new BankDetails();
		BeanUtils.copyProperties(bankDetailsUpdate, bankDetails);
		BankDetails bankDetails2 = bankDetailsRepository.findById(bankDetailsUpdate.getAccountNo()).orElse(null);
		if (bankDetails2 != null) {
			bankDetails2.setAccountNo(bankDetailsUpdate.getAccountNo());
			bankDetails2.setAccountType(bankDetailsUpdate.getAccountType());
			bankDetails2.setBankName(bankDetailsUpdate.getBankName());
			bankDetails2.setBranch(bankDetailsUpdate.getBranch());
			bankDetails2.setIfscCode(bankDetailsUpdate.getIfscCode());
			bankDetails2.setState(bankDetailsUpdate.getState());

			return bankDetailsRepository.save(bankDetails2);

		}
		throw new InvalidId("bank details not updated");
	}

	@Override
	public ContactInfo contactUpdate(ContactDto contactUpdate) {
		
		ContactInfo contact = new ContactInfo();
		BeanUtils.copyProperties(contactUpdate, contact);
		ContactInfo contact2 = contactRepository.findById(contactUpdate.getContactNumber()).orElse(null);
		if (contact2 != null) {
			contact2.setContactNumber(contactUpdate.getContactNumber());
			contact2.setContactType(contactUpdate.getContactType());
			return contactRepository.save(contact2);
		}
		throw new InvalidId("contact details not updated");
	}

	@Override
	public EducationalDetails educationupdate(EducationalDetailsDto educationUpdate) {
		EducationalDetails educationDetails = new EducationalDetails();
		BeanUtils.copyProperties(educationUpdate, educationDetails);
		EducationalDetails educationDetails2 = educationalRepository.findById(educationUpdate.getsNo()).orElse(null);
		if (educationDetails2 != null) {
			educationDetails2.setInstituteName(educationUpdate.getInstituteName());
			educationDetails2.setEducationType(educationUpdate.getEducationType());
			educationDetails2.setPercentage(educationUpdate.getPercentage());
			educationDetails2.setSpecialization(educationUpdate.getSpecialization());
			educationDetails2.setState(educationUpdate.getState());
			educationDetails2.setUniversityName(educationUpdate.getUniversityName());
			educationDetails2.setYearOfPassing(educationUpdate.getYearOfPassing());
			return educationalRepository.save(educationDetails2);
		}
		throw new InvalidId("education details not updated");
	}

	@Override
	public TechnicalInfo technicalUpdate(TechnicalDto infoUpdate) {
		TechnicalInfo info =new TechnicalInfo();
		BeanUtils.copyProperties(infoUpdate, info);
		TechnicalInfo technicalInfo=technicalRepository.findById(infoUpdate.getsNo()).orElse(null);
		if(technicalInfo != null) {
			technicalInfo.setSkillRating(infoUpdate.getSkillRating());
			technicalInfo.setSkillType(infoUpdate.getSkillType());
			technicalInfo.setYearOfExperience(infoUpdate.getYearOfExperience());
			
			return technicalRepository.save(technicalInfo);
		}
		throw new InvalidId("technical details not updated");
	}

	@Override
	public ExperienceInfo getExperienceUpdate(ExperienceDto infoUpdate) {
		ExperienceInfo employeeExperienceInfo =new ExperienceInfo();
		BeanUtils.copyProperties(infoUpdate, employeeExperienceInfo);
		ExperienceInfo employeeExperienceInfo2=experienceRepository.findById(infoUpdate.getsNo()).orElse(null);
		if(employeeExperienceInfo2 != null) {
			employeeExperienceInfo2.setCompanyName(infoUpdate.getCompanyName());
			employeeExperienceInfo2.setDateOfJoining(infoUpdate.getDateOfJoining());
			employeeExperienceInfo2.setDateOfRelieving(infoUpdate.getDateOfRelieving());
			employeeExperienceInfo2.setDesignation(infoUpdate.getDesignation());
			employeeExperienceInfo2.setLocation(infoUpdate.getLocation());
			employeeExperienceInfo2.setYearOfExperience(infoUpdate.getYearOfExperience());
			
			return experienceRepository.save(employeeExperienceInfo2);
		}
		throw new InvalidId("experience details not updated");
	}
//get data of employee
	@Override
	public  PrimaryInfo getEmployeedata(PrimaryInfoDto employeeDto) {
		PrimaryInfo primaryInfo=new PrimaryInfo();
		BeanUtils.copyProperties(employeeDto, primaryInfo);
		PrimaryInfo getdata = primaryInfoRepository.findById(primaryInfo.getEmpId()).orElse(null);
		if(getdata!=null) {
			return getdata;
		}
		throw new InvalidId("no records found");
	}
//create mentor	
	@Override
	public Mentor createMentorList(MentorListDto list) {
		if(list.getMentorId().startsWith("TYM")) {
			Mentor lists = new Mentor();
			BeanUtils.copyProperties(list, lists);
			mentorEntityRepository.save(lists);
			return (lists);
		}
		
		throw new InvalidId("no records found");
			
	}


//update mentor
	@Override
	public Mentor createMentorUpdate(MentorUpdateDto dto) {
		
		Mentor list = new Mentor();
		BeanUtils.copyProperties(dto, list);
	Mentor mentordetails=mentorEntityRepository.findById(list.getMentorId()).orElse(null);
		if(mentordetails != null) {
			list.setMentorEmailId(dto.getMentorEmailId());
			list.setMentorName(dto.getMentorName());
			list.setSkills(dto.getSkills());
			return mentorEntityRepository.save(list);
	
		}
		throw new InvalidId("Mentor details not updated");
	}
//delete mentor
	@Override
	public boolean createMentorDelete(MentorDeleteDto deleteDto) {
		boolean isRegister=false;
		Mentor list = new Mentor();
		BeanUtils.copyProperties(deleteDto, list);
		Mentor list2 = mentorEntityRepository.findById(list.getMentorId()).orElse(null);
		if(list2 != null) {
			mentorEntityRepository.delete(list2);
			isRegister=true;
		}
		return isRegister;
	}
//search batch
@Override
	public BatchDetails searchBatchDetails(BatchDetailsDto batchDetailDto) {
		if (batchDetailDto.getEmpBatchId().startsWith("TYB")) {
			if (batchDetailDto.getEmpBatchId().equals(batchDetailDto.getEmpBatchId())) {
				BeanUtils.copyProperties(batchDetailDto, batchDetails);
				BatchDetails searchbatch = batchDetailRepository.findById(batchDetailDto.getEmpBatchId())
						.orElse(null);
				if (searchbatch != null) {
					return searchbatch;
				} else {
					throw new InvalidId("no batch found");
				}
			}
			throw new InvalidId("no batch id present");

		}
		throw new InvalidId("batch id must start with TYB");
	}

//Batch CRUD API's
@Override
public BatchDetails createBatchDetails(BatchDetails batchDetails) {
	BatchDetails save = batchDetailRepository.save(batchDetails);
// save = batchDetailsRepository.save(batchDetails);
	if (save != null) {
		return save;
	}else {
		throw new InvalidId("batch not created");
	}
}

@Override
public BatchDetails getBatchDetails(BatchDetailsDto batchDetailDto) {
	BeanUtils.copyProperties(batchDetailDto, batchDetails);
	BatchDetails getbatchdetail = batchDetailRepository.findById(batchDetailDto.getEmpBatchId())
			.orElse(null);
	return getbatchdetail;
}

@Override
public BatchDetails updateBatchDetails(BatchDetailsDto batchDetailDto) {
	BeanUtils.copyProperties(batchDetailDto, batchDetails);
	BatchDetails updatebatch = batchDetailRepository.findById(batchDetailDto.getEmpBatchId())
			.orElse(null);
	if (updatebatch != null) {
		batchDetails.setEmpBatchId(batchDetailDto.getEmpBatchId());
		batchDetails.setEmpBatchName(batchDetailDto.getEmpBatchName());
		batchDetails.setEmpMentorName(batchDetailDto.getEmpMentorName());
		batchDetails.setEmpTechnologies(batchDetailDto.getEmpTechnologies());
		batchDetails.setEmpStartDate(batchDetailDto.getEmpStartDate());
		batchDetails.setEmpEndDate(batchDetailDto.getEmpEndDate());
		batchDetails.setEmpAction(batchDetailDto.getEmpAction());
		batchDetails.setEmpStatus(batchDetailDto.getEmpStatus());
		batchDetails.setEmpStrength(batchDetailDto.getEmpBatchStrength());
		batchDetailRepository.save(batchDetails);
		return batchDetails;
	}
	throw new InvalidId("batch not updated");
}

@Override
public String deleteBatchDetails(BatchDetailsDto batchDetailDto) {
	BeanUtils.copyProperties(batchDetailDto, batchDetails);
	batchDetailRepository.deleteById(batchDetailDto.getEmpBatchId());
	return null;
}

@Override
public List<RequestListForEmployee> employeeRequest() {
List<RequestApproval> findAll = requestApprovalRepository.findAll();
	
	List<RequestListForEmployee> forEmployee = new ArrayList<RequestListForEmployee>();
	
	for(RequestApproval demoDto :findAll) {
		forEmployee.add(new RequestListForEmployee(demoDto.getEmployeeId(),demoDto.getEmployeeName(),
				demoDto.getExperience(),demoDto.getPercentage(),demoDto.getContactNumber()));
	}
	
	return forEmployee;
}

@Override
public ArrayList<StatusDto> approve() {
	List<BatchDetails> findAll = batchDetailRepository.findAll();
	ArrayList<StatusDto> arrayList = new ArrayList<>();
	for (BatchDetails employee : findAll) {
		arrayList.add(new StatusDto(employee.getEmpBatchId(), employee.getEmpBatchName()));
	}
	return arrayList;
}

@Override
public void approveStoring(AdminShowRequestDto adminShowRequestDto) {
	ApproveListByAdmin admin =new ApproveListByAdmin();
	BeanUtils.copyProperties(adminShowRequestDto, admin);
	approveRepositary.save(admin);
	
}


public List<BatchDetails> getBatchList(BatchDetails batchDetails) {
	List<BatchDetails> getbatchList = batchDetailRepository.findAll();
	if(getbatchList!=null) {
		return getbatchList;
	}
	throw new InvalidId("no batch found");
	
}

	


}
