package com.te.allerganlms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer quizId;
	@NotBlank(message = "Quiz Name cannot be empty")
	private String quizName;
	private Integer quizMarks;
	private Status quizStatus;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizAttempts")
	@SequenceGenerator(name = "quizAttemptsSeq", initialValue = 1, allocationSize = 3)
	private Integer quizAttempts;

	@ManyToOne
	private Asset asset;

}
