package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.models.Answer;
import com.evilcorp.trollquiz.models.QuizQuestion;

public interface UserModelService {
    public boolean addQuestion(QuizQuestion quizQuestion);
    public boolean updateQuestion(QuizQuestion quizQuestion);
    public boolean deleteQuestion(long id);
    public boolean addAnswer(QuizQuestion quizQuestion, Answer answer);
    public boolean deleteAnswer(long id);
}
