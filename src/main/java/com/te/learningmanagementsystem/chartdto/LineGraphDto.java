package com.te.learningmanagementsystem.chartdto;

import org.springframework.stereotype.Component;

@Component
public class LineGraphDto {

	public LineGraphDto() {
		super();
	}

	private  String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
