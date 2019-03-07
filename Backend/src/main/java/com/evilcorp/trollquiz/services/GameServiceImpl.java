package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.repositories.QuizQuestionRepository;
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

    @Autowired
    public GameServiceImpl(QuizQuestionRepository quizQuestionRepository) {
        this.quizQuestionRepository = quizQuestionRepository;
    }

    public QuizQuestionDto getGameQuestion() {
        QuizQuestion quizQuestion = quizQuestionRepository.getOne((long) new Random().nextInt(quizQuestionRepository.findAll().size()));
        return mapQuizQuestionToDto(quizQuestion);
    }

    @Override
    public boolean GetAnswer(long id, String answer) {
        return false;
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
                responseQuestionDto.answers.add(quizQuestion.getAnswers().stream().filter(answer -> answer.isCorrect()).findFirst().get().getText());
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
