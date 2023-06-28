package com.te.allerganlms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.allerganlms.dto.QuizCreationDto;
import com.te.allerganlms.entity.Quiz;
import com.te.allerganlms.entity.Status;
import com.te.allerganlms.response.LmsResponse;
import com.te.allerganlms.serviceImplementation.QuizServiceImp;

@RestController
@RequestMapping("/QUIZ")
//@PreAuthorize(value = "hasRole('ADMIN')")
public class QuizController {
	@Autowired
	private QuizServiceImp quizServiceImp;

	@PostMapping("/CREATEQUIZ/{courseId}")
	public ResponseEntity<LmsResponse> createQuiz(@PathVariable Integer courseId,
			@RequestBody QuizCreationDto quizCreationDto) {
		Quiz createQuiz = quizServiceImp.createQuiz(courseId, quizCreationDto);
		LmsResponse lmsResponse = LmsResponse.builder().data(createQuiz).error(false).message("Quiz added successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@GetMapping("/GETQUIZ/{quizId}")
	public ResponseEntity<LmsResponse> getQuiz(@PathVariable Integer quizId) {
		Quiz group = quizServiceImp.getQuiz(quizId);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Quiz fetched successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEQUIZATTEMPTS/{quizId}/{quizAttempts}")
	public ResponseEntity<LmsResponse> updateQuizAttempts(@PathVariable Integer quizId,
			@PathVariable Integer quizAttempts) {
		Quiz group = quizServiceImp.updateQuizAttempts(quizId, quizAttempts);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Quiz updated successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEQUIZNAME/{quizId}/{quizName}")
	public ResponseEntity<LmsResponse> updateQuizName(@PathVariable Integer quizId, @PathVariable String quizName) {
		Quiz group = quizServiceImp.updateQuizName(quizId, quizName);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Quiz updated successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEQUIZMARKS/{quizId}/{quizMarks}")
	public ResponseEntity<LmsResponse> updateQuizMarks(@PathVariable Integer quizId, @PathVariable Integer quizMarks) {
		Quiz group = quizServiceImp.updateQuizMarks(quizId, quizMarks);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Quiz updated successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PutMapping("/UPDATEQUIZSTATUS/{quizId}/{status}")
	public ResponseEntity<LmsResponse> updateQuizStatus(@PathVariable Integer quizId, @PathVariable Status status) {
		Quiz group = quizServiceImp.updateQuizStatus(quizId, status);
		LmsResponse lmsResponse = LmsResponse.builder().data(group).error(false).message("Quiz updated successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@DeleteMapping("/DELETEQUIZ/{quizId}")
	public ResponseEntity<LmsResponse> deleteQuiz(@PathVariable Integer quizId) {
		quizServiceImp.deleteQuiz(quizId);
		LmsResponse lmsResponse = LmsResponse.builder().error(false).message("Quiz deleted successfully").build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@PostMapping("/GETALL")
	public ResponseEntity<LmsResponse> getAll() {
		List<Quiz> quiz = quizServiceImp.getAll();
		LmsResponse lmsResponse = LmsResponse.builder().data(quiz).error(false).message("Quiz fetched successfully")
				.build();
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}
}
