package com.te.learningmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.learningmanagementsystem.chartdto.BatchDto;
import com.te.learningmanagementsystem.chartdto.FetchMockDetails;
import com.te.learningmanagementsystem.chartdto.LineGraphDto;
import com.te.learningmanagementsystem.chartservice.BatchService;
import com.te.learningmanagementsystem.entity.BatchDetails;
import com.te.learningmanagementsystem.response.LmsResponse;



@RestController
public class DashBoardAndLineGraphChartController {
	
	@Autowired
	private BatchService batchService;
	@Autowired
	private LmsResponse lmsResponse;
	
	
	@PostMapping("/batchdashboard")
	public ResponseEntity<LmsResponse> getBatchGraph(@RequestBody BatchDto batchDto){
		 Object object= batchService.gender(batchDto);
		 object = batchService.yearOfPassing(batchDto); 
		 object = batchService.experience(batchDto);
		object= batchService.education(batchDto); 
		object= batchService.batchperformance(batchDto);
		
		lmsResponse.setData(object);
	return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
		 
	}
	
	@PostMapping("/linechart")
	public ResponseEntity<LmsResponse> getLineGraph(@RequestBody LineGraphDto dto) {
		List<FetchMockDetails> mockDetails = batchService.getMockDetails(dto);
		if(mockDetails != null) {
			lmsResponse.setData(mockDetails);
			lmsResponse.setMessage("data fetch successfully");
			return new ResponseEntity<LmsResponse>(lmsResponse,HttpStatus.ACCEPTED);
		}
		return null;
	}

}
