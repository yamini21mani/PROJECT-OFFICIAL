package com.te.onlineTestPortal.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionNo")
	@SequenceGenerator(name = "questionNo", initialValue = 1,allocationSize = 1)
	private Integer questionNo;
	@NotNull(message = "enter the question")
	private String question;
	@NotNull(message = "enter the MCQ answers")
	@ElementCollection
	private List<String> options;
	@ElementCollection
	@JoinColumn
	private  Map<String,String> correctAnswer;
	@Enumerated(EnumType.STRING)
	private ExamLevel level;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private SubjectCategory subjectCategory;

}
