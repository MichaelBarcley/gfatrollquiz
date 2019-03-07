package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;
import org.springframework.stereotype.Service;

@Service
public class UserModelServiceImpl implements UserModelService {
    @Override
    public boolean AddQuestion(QuizQuestion quizQuestion) {
        return false;
    }

    @Override
    public boolean UpdateQuestion(QuizQuestion quizQuestion) {
        return false;
    }

    @Override
    public boolean DeleteQuestion(long id) {
        return false;
    }

    @Override
    public boolean AddAnswer(QuizQuestion quizQuestion, Answer answer) {
        return false;
    }

    @Override
    public boolean DeleteAnswer(long id) {
        return false;
    }
}
