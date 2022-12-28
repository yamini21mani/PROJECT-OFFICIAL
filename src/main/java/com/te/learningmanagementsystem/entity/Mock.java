package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table
public class Mock {

	@Id
//	@NotNull
	private Integer sno;
//	@NotNull
	private String mockno;
//	@NotNull
	private String technology;
//	@NotNull
	private String panel;
//	@NotNull
	private String dateAndTime;
//	@NotNull
	private String mockRating;

	// @ManyToOne(cascade = CascadeType.ALL)
   //private Batch_Details batch_Details;
	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getMockno() {
		return mockno;
	}

	public void setMockno(String mockno) {
		this.mockno = mockno;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getMockRating() {
		return mockRating;
	}

	public void setMockRating(String mockRating) {
		this.mockRating = mockRating;
	}

}
