package com.te.learningmanagementsystem.chartservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.learningmanagementsystem.chartdto.BatchDto;
import com.te.learningmanagementsystem.chartdto.EmpBatchPerformance;
import com.te.learningmanagementsystem.chartdto.EmpEducationType;
import com.te.learningmanagementsystem.chartdto.EmpGender;
import com.te.learningmanagementsystem.chartdto.EmpYearOfExperience;
import com.te.learningmanagementsystem.chartdto.EmpYearOfPassing;
import com.te.learningmanagementsystem.chartdto.FetchMockDetails;
import com.te.learningmanagementsystem.chartdto.LineGraphDto;
import com.te.learningmanagementsystem.entity.EmployeelistInBatch;
import com.te.learningmanagementsystem.entity.BatchDetails;
import com.te.learningmanagementsystem.entity.EducationalDetails;
import com.te.learningmanagementsystem.entity.ExperienceInfo;
import com.te.learningmanagementsystem.entity.PrimaryInfo;
import com.te.learningmanagementsystem.repository.BatchDetailRepository;
import com.te.learningmanagementsystem.repository.EducationalRepository;
import com.te.learningmanagementsystem.repository.EmployeelistRepositary;
import com.te.learningmanagementsystem.repository.ExperienceRepository;
import com.te.learningmanagementsystem.repository.PrimaryInfoRepository;
@Service
public class BatchServiceImp implements BatchService {

	@Autowired
	private EducationalRepository educationalRepositary;

	@Autowired
	private EmployeelistRepositary employeeListRepositary;

	@Autowired
	private ExperienceRepository experienceRepositary;

	@Autowired
	private PrimaryInfoRepository primaryRepositary;

	@Autowired
	private EmployeelistInBatch batch;

	@Autowired
	private BatchDetails batchDetails;
	
	@Autowired
	private BatchDetailRepository batchDetailRepository;

	@Override
	public List<EmpGender> gender(BatchDto batchDto) {
		BeanUtils.copyProperties(batchDto, batchDetails);
		List<EmpGender> gen = new ArrayList<EmpGender>();
		List<PrimaryInfo> list = primaryRepositary.findAll();
		for (PrimaryInfo primaryInfo : list) {
			gen.add(new EmpGender(primaryInfo.getGender()));
		}

		return gen;
	}

	@Override
	public List<EmpYearOfPassing> yearOfPassing(BatchDto batchDto) {
		BeanUtils.copyProperties(batchDto, batchDetails);
		List<EmpYearOfPassing> empYearOfPassings = new ArrayList<EmpYearOfPassing>();
		List<EducationalDetails> details = educationalRepositary.findAll();
		for (EducationalDetails educationaI_Details : details) {
			empYearOfPassings.add(new EmpYearOfPassing(educationaI_Details.getYearOfPassing()));

		}
		return empYearOfPassings;
	}

	@Override
	public List<EmpYearOfExperience> experience(BatchDto batchDto) {
		BeanUtils.copyProperties(batchDto, batchDetails);

		List<EmpYearOfExperience> empYearOfExperiences = new ArrayList<EmpYearOfExperience>();
		List<ExperienceInfo> experienceInfos = experienceRepositary.findAll();

		for (ExperienceInfo experienceInfo : experienceInfos) {
			empYearOfExperiences.add(new EmpYearOfExperience(experienceInfo.getYearOfExperience()));
		}
		return empYearOfExperiences;
	}

	@Override
	public List<EmpEducationType> education(BatchDto batchDto) {
		BeanUtils.copyProperties(batchDto, batchDetails);

		List<EmpEducationType> empEducationTypes = new ArrayList<EmpEducationType>();
		List<EducationalDetails> details = educationalRepositary.findAll();
		for (EducationalDetails educationaI_Details : details) {
			empEducationTypes.add(new EmpEducationType(educationaI_Details.getEducationType()));
		}
		return empEducationTypes;
	}

	@Override
	public List<EmpBatchPerformance> batchperformance(BatchDto batchDto) {
		BeanUtils.copyProperties(batchDto, batchDetails);

		List<EmpBatchPerformance> empBatchPerformances = new ArrayList<EmpBatchPerformance>();
		List<EmployeelistInBatch> batchs = employeeListRepositary.findAll();

		for (EmployeelistInBatch employeelistInBatch : batchs) {
			empBatchPerformances.add(new EmpBatchPerformance(employeelistInBatch.getMockRating()));
		}
		return empBatchPerformances;
	}

	@Override
	public List<FetchMockDetails> getMockDetails(LineGraphDto dto) {
		BeanUtils.copyProperties(dto, batch);
		List<FetchMockDetails> details = new ArrayList<FetchMockDetails>();
		List<EmployeelistInBatch> orElse = (List<EmployeelistInBatch>) employeeListRepositary.findById(batch.getEmployeeId()).orElse(null);
		for (EmployeelistInBatch employeelistInBatch : orElse) {

			details.add(
					new FetchMockDetails(employeelistInBatch.getMockTakenBy(), employeelistInBatch.getMockRating()));
		}
		return details;
	}
}
