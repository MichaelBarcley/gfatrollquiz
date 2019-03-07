package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.repositories.QuizQuestionRepository;
import com.evilcorp.trollquiz.services.dto.QuizQuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl {
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    public GameServiceImpl(QuizQuestionRepository quizQuestionRepository) {
        this.quizQuestionRepository = quizQuestionRepository;
    }

    public QuizQuestionDto getGameQuestion(){
        QuizQuestion quizQuestion = quizQuestionRepository.getOne((long) new Random().nextInt(quizQuestionRepository.findAll().size()));
        return mapQuizQuestionToDto(quizQuestion);
    }

    private QuizQuestionDto mapQuizQuestionToDto(QuizQuestion quizQuestion) {
        return new QuizQuestionDto();
    }
}
