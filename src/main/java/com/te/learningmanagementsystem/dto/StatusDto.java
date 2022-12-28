package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Component
public class StatusDto {
	@Id
	private String empBatchId;
	private String empBatchName;
	private String rejectMsg;
	
	public StatusDto(String emp_batch_id, String emp_batch_name) {
		super();
		this.empBatchId = empBatchId;
		this.empBatchName = empBatchName;
	}
	public StatusDto() {
		
	}
	public String getEmpBatchId() {
		return empBatchId;
	}
	public void setEmpBatchId(String empBatchId) {
		this.empBatchId = empBatchId;
	}
	public String getEmpBatchName() {
		return empBatchName;
	}
	public void setEmpBatchName(String empBatchName) {
		this.empBatchName = empBatchName;
	}
	public String getRejectMsg() {
		return rejectMsg;
	}
	public void setRejectMsg(String rejectMsg) {
		this.rejectMsg = rejectMsg;
	}


	

}