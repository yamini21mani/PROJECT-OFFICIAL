package com.te.learningmanagementsystem.chartdto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EmpYearOfExperience {

	private String yearOfExperience;

	public EmpYearOfExperience(String string) {
		super();
		this.yearOfExperience = string;
	}

	public EmpYearOfExperience() {
		super();
	}
}
