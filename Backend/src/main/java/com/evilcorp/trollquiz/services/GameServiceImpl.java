package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.models.UserModel;
import com.evilcorp.trollquiz.repositories.AnswerRepository;
import com.evilcorp.trollquiz.repositories.QuizQuestionRepository;
import com.evilcorp.trollquiz.repositories.UserModelRepository;
import com.evilcorp.trollquiz.services.dto.QuizQuestionDto;
import com.evilcorp.trollquiz.services.dto.ScoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {
    private QuizQuestionRepository quizQuestionRepository;
    private UserModelRepository userModelRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public GameServiceImpl(QuizQuestionRepository quizQuestionRepository, UserModelRepository userModelRepository, AnswerRepository answerRepository) {
        this.quizQuestionRepository = quizQuestionRepository;
        this.userModelRepository = userModelRepository;
        this.answerRepository = answerRepository;
    }

    public QuizQuestionDto getGameQuestion() {
        QuizQuestion quizQuestion = quizQuestionRepository.getOne((long) new Random().nextInt(quizQuestionRepository.findAll().size()));
        return mapQuizQuestionToDto(quizQuestion);
    }

    @Override
    public boolean GetAnswer(long userId, long id, String answer) {
        QuizQuestion quizQuestion = quizQuestionRepository.findById(id).get();
        if(answer.equalsIgnoreCase(quizQuestion.getAnswers().stream().filter(Answer::isCorrect).findAny().get().getText())) {
            UserModel user = userModelRepository.findById(userId).get();
            user.setPoints(user.getPoints() + 1);
            user.setCoins(user.getCoins() + 1);
            return true;
        } else {
            Answer chosenAnswer = answerRepository.findAll().stream().filter(answer1 -> answer1.getText().equalsIgnoreCase(answer)).findFirst().get();
            UserModel user = chosenAnswer.getUserModel();
            user.setPoints(user.getPoints() + 1);
            user.setCoins(user.getCoins() + 1);
            return false;
        }
    }

    @Override
    public List<ScoreDto> GetLeaderboard() {
        return null;
    }

    private QuizQuestionDto mapQuizQuestionToDto(QuizQuestion quizQuestion) {
        QuizQuestionDto responseQuestionDto = new QuizQuestionDto();
        responseQuestionDto.id = quizQuestion.getId();
        responseQuestionDto.question = quizQuestion.getQuestion();
        responseQuestionDto.answers = new ArrayList<>();
        int correctResponse = new Random().nextInt(3);
        for(int i = 0; i < 4; i++) {
            if(i == correctResponse) {
                responseQuestionDto.answers.add(quizQuestion.getAnswers().stream().filter(Answer::isCorrect).findFirst().get().getText());
            } else {
                boolean isUnchecked = true;
                int answerId = new Random().nextInt(quizQuestion.getAnswers().size() -1);
                while (isUnchecked) {
                    if(!responseQuestionDto.answers.contains(quizQuestion.getAnswers().get(answerId).getText())) {
                        responseQuestionDto.answers.add(quizQuestion.getAnswers().get(answerId).getText());
                        isUnchecked = false;
                    }
                }
            }
        }
        return responseQuestionDto;
    }
}
