package com.te.learningmanagementsystem.chartservice;

import java.util.List;

import com.te.learningmanagementsystem.chartdto.BatchDto;
import com.te.learningmanagementsystem.chartdto.EmpBatchPerformance;
import com.te.learningmanagementsystem.chartdto.EmpEducationType;
import com.te.learningmanagementsystem.chartdto.EmpGender;
import com.te.learningmanagementsystem.chartdto.EmpYearOfExperience;
import com.te.learningmanagementsystem.chartdto.EmpYearOfPassing;
import com.te.learningmanagementsystem.chartdto.FetchMockDetails;
import com.te.learningmanagementsystem.chartdto.LineGraphDto;
import com.te.learningmanagementsystem.entity.BatchDetails;

public interface BatchService {

	
	List<EmpGender> gender(BatchDto batchDto);

	List<EmpYearOfPassing> yearOfPassing(BatchDto batchDto);

	List<EmpYearOfExperience> experience(BatchDto batchDto);

	List<EmpEducationType> education(BatchDto batchDto);

	List<EmpBatchPerformance> batchperformance(BatchDto batchDto);

	List<FetchMockDetails> getMockDetails(LineGraphDto dto);
	
}
