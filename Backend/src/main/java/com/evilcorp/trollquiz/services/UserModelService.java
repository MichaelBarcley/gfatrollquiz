package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;

public interface UserModelService {
    public boolean AddQuestion(QuizQuestion quizQuestion);
    public boolean UpdateQuestion(QuizQuestion quizQuestion);
    public boolean DeleteQuestion(long id);
    public boolean AddAnswer(QuizQuestion quizQuestion, Answer answer);
    public boolean DeleteAnswer(long id);
}
