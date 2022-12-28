package com.te.learningmanagementsystem.chartdto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class FetchMockDetails {

public FetchMockDetails() {
		super();
	}

private String mockTaken;
	
	private String mockRating;
	
	
	public String getMockTaken() {
		return mockTaken;
	}
	public void setMockTaken(String mockTaken) {
		this.mockTaken = mockTaken;
	}
	public String getMockRating() {
		return mockRating;
	}
	
	public void setMockRating(String mockRating) {
		this.mockRating = mockRating;
	}
	public FetchMockDetails(String mockTaken) {
		super();
		this.mockTaken = mockTaken;
	}
	
	public FetchMockDetails(String string, String string2) {
		super();
		this.mockTaken = string;
		this.mockRating = string2;
	}
}
