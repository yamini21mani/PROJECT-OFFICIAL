package com.te.onlineTestPortal.entity;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class ExamScheduler {
	@Id
	private String schedulerId;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime startDate;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime endDate;
	@OneToOne(cascade = CascadeType.ALL)
	private SubjectCategory subjectName;
	@ElementCollection
	private Map<Timing, Integer> noOfSchedules;

	public ExamScheduler() {
		noOfSchedules = new EnumMap<>(Timing.class);
	}
	
	

	public Map<Timing, Integer> getSchedules() {
		return noOfSchedules;
	}

}
