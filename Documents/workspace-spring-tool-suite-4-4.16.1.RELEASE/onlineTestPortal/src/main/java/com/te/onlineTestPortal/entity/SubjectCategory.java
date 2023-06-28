package com.te.onlineTestPortal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class SubjectCategory {
	@Id
	@JsonFormat
	private String subCode;
	private String subId;
	@NotNull(message = "category cannot be null")
	@JsonFormat
	private String category;
	@NotNull(message = "subject name cannot be null")
	private String subjectName;
	
	

}
