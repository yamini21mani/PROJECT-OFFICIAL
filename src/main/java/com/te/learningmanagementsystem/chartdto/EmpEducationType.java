package com.te.learningmanagementsystem.chartdto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EmpEducationType {

	private String educationType;

	public EmpEducationType(String string) {
		super();
		this.educationType = string;
	}

	public EmpEducationType() {
		super();
	}
}
