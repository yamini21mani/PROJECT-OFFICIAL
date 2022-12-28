package com.te.learningmanagementsystem.entity;


import java.util.List;

import org.springframework.stereotype.Component;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Component
@Entity
@Table

public class BatchDetails {
	@Id
//	@NotNull
	private String empBatchId;
//	@NotNull
	private String empBatchName;
//	@NotNull
	private String empMentorName;
//	@NotNull
	private String empTechnologies;
//	@NotNull
	private String empStartDate;
//	@NotNull
	private String empEndDate;
//	@NotNull
	private String empStatus;
//	@NotNull
	private String empAction;
//	@NotNull
	private String empStrength;
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;

	public String getEmpStrength() {
		return empStrength;
	}

	public void setEmpStrength(String empStrength) {
		this.empStrength = empStrength;
	}

	public String getEmpBatchId() {
		return empBatchId;
	}

	public void setEmpBatchId(String empBatchId) {
		this.empBatchId = empBatchId;
	}

	public String getEmpBatchName() {
		return empBatchName;
	}

	public void setEmpBatchName(String empBatchName) {
		this.empBatchName = empBatchName;
	}

	public String getEmpTechnologies() {
		return empTechnologies;
	}

	public void setEmpTechnologies(String empTechnologies) {
		this.empTechnologies = empTechnologies;
	}

	public String getEmpStartDate() {
		return empStartDate;
	}

	public void setEmpStartDate(String empStartDate) {
		this.empStartDate = empStartDate;
	}

	
	public String getEmpEndDate() {
		return empEndDate;
	}

	public void setEmpEndDate(String empEndDate) {
		this.empEndDate = empEndDate;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpAction() {
		return empAction;
	}

	public void setEmpAction(String empAction) {
		this.empAction = empAction;
	}

	public String getEmpMentorName() {
		return empMentorName;
	}

	public void setEmpMentorName(String empMentorName) {
		this.empMentorName = empMentorName;
	}
//	@OneToMany(targetEntity = Mock_Details.class,cascade = CascadeType.ALL)
//	@JoinColumn(name ="batchId",referencedColumnName = "empbatchid" )
//	private List<Mock_Details> mock_Details;
//
//	@OneToMany(targetEntity = Mock_Info.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "batchId",referencedColumnName = "empbatchid")
//	private List<Mock_Info> mock_Info;
//	
//	@OneToMany(targetEntity = Mentor_Entity.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "batchId",referencedColumnName = "empbatchid")
//	private List<Mentor_Entity> mentor_Entities;
	
	//for batchSave
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "batchId",referencedColumnName = "empBatchId")
	private List<Employee> mentorDisplays;
	
	@OneToMany(targetEntity = Mock.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "batchId",referencedColumnName = "empBatchId")
	private List<Mock> mock;
	
	//for dashboard
	
	@OneToMany(targetEntity = EducationalDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "edu_batchId",referencedColumnName = "empBatchId")
	private List<EducationalDetails>  educationaI_Details;
	
	@OneToMany(targetEntity = ExperienceInfo.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "exp_batchId",referencedColumnName = "empBatchId")
	private List<ExperienceInfo>  experienceInfo;
	
	@OneToMany(targetEntity =PrimaryInfo.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pri_batchId",referencedColumnName = "empBatchId")
	private List<PrimaryInfo>	 primaryInfo;
	
	@OneToMany(targetEntity =EmployeelistInBatch .class,cascade = CascadeType.ALL)
	@JoinColumn(name = "empList_batchId",referencedColumnName = "empBatchId")
	private List<EmployeelistInBatch>	batchs;


	public List<EducationalDetails> getEducationaI_Details() {
		return educationaI_Details;
	}

	public void setEducationaI_Details(List<EducationalDetails> educationaI_Details) {
		this.educationaI_Details = educationaI_Details;
	}

	public List<ExperienceInfo> getExperience_Info() {
		return experienceInfo;
	}

	public void setExperience_Info(List<ExperienceInfo> experienceInfo) {
		this.experienceInfo = experienceInfo;
	}

	public List<PrimaryInfo> getPrimary_Info() {
		return primaryInfo;
	}

	public void setPrimary_Info(List<PrimaryInfo> primaryInfo) {
		this.primaryInfo = primaryInfo;
	}

	public List<EmployeelistInBatch> getBatchs() {
		return batchs;
	}

	public void setBatchs(List<EmployeelistInBatch> batchs) {
		this.batchs = batchs;
	}

}
