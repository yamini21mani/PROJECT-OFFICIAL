package com.te.learningmanagementsystem.entity;

import java.util.List;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;

//import com.te.springboot.entity.EmployeeBatchDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Component
public class PrimaryInfo {
	@Id
	private String empId;
	private String empName;
	private String doj;
	private String dob;
	private String emailId;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String empStatus;
	private int attendance;
	private String empPass;
	private int count ;

	
	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String i) {
		this.empPass = i;
	}

//
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Secondary_Info secondary_Info;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Educational_Details educational_Details;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Address_Info address_Info;
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Bank_Details bank_Details;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Technical_Info technical_Info;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Experience_Info experience_Info;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Contact_Info contact_Info;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary_Info")
//	private Batch_Details batch_Details;


	@OneToOne(targetEntity = SecondaryInfo.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "empId",  referencedColumnName = "empId")
	private SecondaryInfo secondary_Info1;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}



	public SecondaryInfo getSecondary_Info1() {
		return secondary_Info1;
	}

	public void setSecondary_Info1(SecondaryInfo secondary_Info1) {
		this.secondary_Info1 = secondary_Info1;
	}

	public BankDetails getBank_Details1() {
		return bank_Details1;
	}

	public void setBank_Details1(BankDetails bank_Details1) {
		this.bank_Details1 = bank_Details1;
	}

	public List<ExperienceInfo> getExpList() {
		return expList;
	}

	public void setExpList(List<ExperienceInfo> expList) {
		this.expList = expList;
	}

	public List<AddressInfo> getAddList() {
		return addList;
	}

	public void setAddList(List<AddressInfo> addList) {
		this.addList = addList;
	}

	public List<ContactInfo> getConList() {
		return conList;
	}

	public void setConList(List<ContactInfo> conList) {
		this.conList = conList;
	}

	public List<EducationalDetails> getEducList() {
		return educList;
	}

	public void setEducList(List<EducationalDetails> educList) {
		this.educList = educList;
	}

	public List<TechnicalInfo> getTechList() {
		return techList;
	}

	public void setTechList(List<TechnicalInfo> techList) {
		this.techList = techList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@OneToOne(targetEntity = BankDetails.class, cascade = CascadeType.ALL)
	private BankDetails bank_Details1;

	@OneToMany(targetEntity = ExperienceInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "exp_empId", referencedColumnName = "empId")
	private List<ExperienceInfo> expList;

	@OneToMany(targetEntity = AddressInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Add_empId", referencedColumnName = "empId")
	private List<AddressInfo> addList;

	@OneToMany(targetEntity = ContactInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Contact_empId", referencedColumnName = "empId")
	private List<ContactInfo> conList;

	@OneToMany(targetEntity = EducationalDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "edu_empId", referencedColumnName = "empId")
	private List<EducationalDetails> educList;

	@OneToMany(targetEntity = TechnicalInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "tech_empId", referencedColumnName = "empId")
	private List<TechnicalInfo> techList;

	@OneToMany(targetEntity = BatchDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_empId", referencedColumnName = "empId")
	private List<BatchDetails> batchDetails;
}
