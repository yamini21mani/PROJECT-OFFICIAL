package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Component
@Table
public class MockRatings {
	@Id
//	@GeneratedValue
//	@NotNull
	private Integer mockId;
//	@NotNull
	private String mockType;
//	@NotNull
	private String mockTakenBy;
//	@NotNull
	private Integer praticalMock;
//	@NotNull
	private Integer theoriticalMock;
//	@NotNull
	private String overallFeedBack;
//	@NotNull
	private String detailsFeddBack;
	
//	
//	@OneToOne (cascade = CascadeType.ALL) 
//	private Batch_Details batch_Details;


	public Integer getMockId() {
		return mockId;
	}

	public void setMockId(Integer mockId) {
		this.mockId = mockId;
	}

	public String getMockType() {
		return mockType;
	}

	public void setMockType(String mockType) {
		this.mockType = mockType;
	}

	public String getMockTakenBy() {
		return mockTakenBy;
	}

	public void setMockTakenBy(String mockTakenBy) {
		this.mockTakenBy = mockTakenBy;
	}

	public Integer getPraticalMock() {
		return praticalMock;
	}

	public void setPraticalMock(Integer praticalMock) {
		this.praticalMock = praticalMock;
	}

	public Integer getTheoriticalMock() {
		return theoriticalMock;
	}

	public void setTheoriticalMock(Integer theoriticalMock) {
		this.theoriticalMock = theoriticalMock;
	}

	public String getOverallFeedBack() {
		return overallFeedBack;
	}

	public void setOverallFeedBack(String overallFeedBack) {
		this.overallFeedBack = overallFeedBack;
	}

	public String getDetailsFeddBack() {
		return detailsFeddBack;
	}

	public void setDetailsFeddBack(String detailsFeddBack) {
		this.detailsFeddBack = detailsFeddBack;
	}

//	public Batch_Details getBatch_Details() {
//		return batch_Details;
//	}
//
//	public void setBatch_Details(Batch_Details batch_Details) {
//		this.batch_Details = batch_Details;
//	}




}
