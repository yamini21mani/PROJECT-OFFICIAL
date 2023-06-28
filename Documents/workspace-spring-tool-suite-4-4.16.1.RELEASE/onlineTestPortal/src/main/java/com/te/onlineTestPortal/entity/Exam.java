package com.te.onlineTestPortal.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Exam {
	@Id
	private String examCode;
	@NotNull(message = "Exam duration can't be empty")
	private Time duration;
	@NotNull(message = "Exam level can't be empty")
	private ExamLevel level;
	@ElementCollection
	@JoinColumn
	private Map<String,String> answerSheet;
	@NotNull(message = "Exam date is mandatory")
	private LocalDate date;
	private Timing time;

	@ManyToOne(cascade = CascadeType.ALL)
	private SubjectCategory category;

}
