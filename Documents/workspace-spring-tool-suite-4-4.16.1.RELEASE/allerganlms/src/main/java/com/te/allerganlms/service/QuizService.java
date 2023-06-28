package com.te.allerganlms.service;

import java.util.List;

import com.te.allerganlms.dto.QuizCreationDto;
import com.te.allerganlms.entity.Quiz;
import com.te.allerganlms.entity.Status;

public interface QuizService {
	// CREATE API
	public Quiz createQuiz(Integer courseId, QuizCreationDto quizCreationDto);

	// FETCH API
	public Quiz getQuiz(Integer quizId);

	// UPDATE API
	public Quiz updateQuizMarks(Integer quizId, Integer quizMarks);

	public Quiz updateQuizName(Integer quizId, String quizName);

	public Quiz updateQuizStatus(Integer quizId, Status status);

	public Quiz updateQuizAttempts(Integer quizId, Integer quizAttempts);

	public List<Quiz> getAll();
	// DELETE API
	public void deleteQuiz(Integer quizId);
}
