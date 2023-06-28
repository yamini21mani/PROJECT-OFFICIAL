package com.te.allerganlms.exceptionHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.allerganlms.response.LmsResponse;

@RestControllerAdvice
public class ExceptionController {
	@Autowired
	private LmsResponse lmsResponse;

	@ExceptionHandler(AssetException.class)
//	@ResponseStatus(value = HttpStatus.BAD_)
	public ResponseEntity<LmsResponse> assetException(AssetException assetException) {
		lmsResponse.setMessage(assetException.getMessage());
		return new ResponseEntity<>(lmsResponse, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(QuizException.class)
	public ResponseEntity<LmsResponse> quizException(QuizException quizException) {
		lmsResponse.setMessage(quizException.getMessage());
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@ExceptionHandler(UserJourneyException.class)
	public ResponseEntity<LmsResponse> userJourneyException(UserJourneyException userJourneyException) {
		lmsResponse.setMessage(userJourneyException.getMessage());
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

	@ExceptionHandler(GroupException.class)
	public ResponseEntity<LmsResponse> groupException(GroupException groupException) {
		lmsResponse.setMessage(groupException.getMessage());
		return new ResponseEntity<>(lmsResponse, HttpStatus.OK);
	}

}
