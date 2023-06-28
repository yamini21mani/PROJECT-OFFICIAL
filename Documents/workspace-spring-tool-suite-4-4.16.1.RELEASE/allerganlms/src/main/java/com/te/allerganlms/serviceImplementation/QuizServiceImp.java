package com.te.allerganlms.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.allerganlms.dto.QuizCreationDto;
import com.te.allerganlms.entity.Asset;
import com.te.allerganlms.entity.Quiz;
import com.te.allerganlms.entity.Status;
import com.te.allerganlms.exceptionHandling.QuizException;
import com.te.allerganlms.repository.AssetRepository;
import com.te.allerganlms.repository.QuizRepository;
import com.te.allerganlms.service.QuizService;

@Service
public class QuizServiceImp implements QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Quiz createQuiz(Integer courseId, QuizCreationDto quizCreationDto) {
		Quiz quiz = Quiz.builder().quizName(quizCreationDto.getQuizName()).quizStatus(Status.INCOMPLETE).quizMarks(0)
				.quizAttempts(0).build();

		Optional<Asset> asset = assetRepository.findById(courseId);
		if (!asset.isEmpty()) {
			Asset asset2 = asset.get();
			quiz.setAsset(asset2);

		}
		return quizRepository.save(quiz);

	}

	@Override
	public Quiz getQuiz(Integer quizId) {
		return quizRepository.findById(quizId)
				.orElseThrow(() -> new QuizException("Unable to fetch the Quiz with mentioned ID"));
	}

	@Override
	public Quiz updateQuizAttempts(Integer quizId, Integer quizAttempts) {
		Quiz findById = quizRepository.findById(quizId).orElseThrow(() -> new QuizException("Unable to find the ID"));
		findById.setQuizAttempts(quizAttempts);
		return quizRepository.save(findById);
	}

	@Override
	public Quiz updateQuizStatus(Integer quizId, Status status) {
		Quiz findById = quizRepository.findById(quizId).orElseThrow(() -> new QuizException("Unable to find the ID"));
		findById.setQuizStatus(status);
		return quizRepository.save(findById);

	}

	@Override
	public Quiz updateQuizName(Integer quizId, String quizName) {
		Quiz findById = quizRepository.findById(quizId).orElseThrow(() -> new QuizException("Unable to find the ID"));
		findById.setQuizName(quizName);
		return quizRepository.save(findById);
	}

	@Override
	public Quiz updateQuizMarks(Integer quizId, Integer quizMarks) {
		Quiz findById = quizRepository.findById(quizId).orElseThrow(() -> new QuizException("Unable to find the ID"));
		findById.setQuizMarks(quizMarks);
		return quizRepository.save(findById);
	}

	@Override
	public void deleteQuiz(Integer quizId) {
		Quiz quiz = quizRepository.findById(quizId)
				.orElseThrow(() -> new QuizException("Unable to find the mentioned ID, please check"));
		quizRepository.delete(quiz);

	}

	@Override
	public List<Quiz> getAll() {
		return quizRepository.findAll();

	}

//	public Quiz getAll(AssetDto assetDto) {
//		List<Quiz> findAll = quizRepository.findAll();
//
//		for (Quiz quiz : findAll) {
//			quiz.getAsset().getCourseId().compareTo(assetDto.getCourseId());
//
//		}
//		return null;
//
//	}

}
