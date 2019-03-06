package com.evilcorp.trollquiz.repositories;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PopulateDatabase implements ApplicationRunner {

  private final UserModelRepository userModelRepository;
  private final QuizQuestionRepository quizQuestionRepository;
  private final AnswerRepository answerRepository;

  @Autowired
  public PopulateDatabase(UserModelRepository userModelRepository,
                          QuizQuestionRepository quizQuestionRepository,
                          AnswerRepository answerRepository) {
    this.userModelRepository = userModelRepository;
    this.quizQuestionRepository = quizQuestionRepository;
    this.answerRepository = answerRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    userModelRepository.save(new UserModel("user", "Peti", "peti@peti.com",
        "asdasd", "1234", 10, 5));
    userModelRepository.save(new UserModel("user", "Misi", "misi@misi.com", "qweqwe", "4567", 5, 10));
    quizQuestionRepository.save(new QuizQuestion("Where?", true));
    quizQuestionRepository.save(new QuizQuestion("Who?", false));
    answerRepository.save(new Answer("Some answer", true));
    answerRepository.save(new Answer("Other answer", false));
  }
}
