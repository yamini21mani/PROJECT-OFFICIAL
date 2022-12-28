package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component

public class MockInfoDto {

	private Integer mockId;
	
	private String mockType;

	private String mockTakenBy;

	private Integer praticalMock;

	private Integer theoriticalMock;
	
	private String overallFeedBack;
	
	private String detailsFeddBack;
	
	

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



}
