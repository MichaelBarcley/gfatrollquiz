package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.repositories.AnswerRepository;
import com.evilcorp.trollquiz.repositories.QuizQuestionRepository;
import com.evilcorp.trollquiz.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModelServiceImpl implements UserModelService {

  private AnswerRepository answerRepository;
  private UserModelRepository userModelRepository;
  private QuizQuestionRepository quizQuestionRepository;

  @Autowired
  public UserModelServiceImpl(AnswerRepository answerRepository,
                              UserModelRepository userModelRepository,
                              QuizQuestionRepository quizQuestionRepository) {
    this.answerRepository = answerRepository;
    this.userModelRepository = userModelRepository;
    this.quizQuestionRepository = quizQuestionRepository;
  }

  @Override
  public boolean addQuestion(QuizQuestion quizQuestion) {
    quizQuestionRepository.save(quizQuestion);
    return true;
  }

  @Override
  public boolean updateQuestion(QuizQuestion quizQuestion) {
    QuizQuestion quizqestionToBeChange = quizQuestionRepository.findById(quizQuestion.getId()).orElse(null);
    quizqestionToBeChange.setAnswers(quizQuestion.getAnswers());
    quizqestionToBeChange.setQuestion(quizQuestion.getQuestion());
    quizqestionToBeChange.setAnswers(quizQuestion.getAnswers());
    quizqestionToBeChange.setUserModel(quizQuestion.getUserModel());
    quizqestionToBeChange.setVerified(quizQuestion.isVerified());
    return true;
  }

  @Override
  public boolean deleteQuestion(long id) {
    return false;
  }

  @Override
  public boolean addAnswer(QuizQuestion quizQuestion, Answer answer) {
    return false;
  }

  @Override
  public boolean deleteAnswer(long id) {
    return false;
  }
}
