package com.evilcorp.trollquiz.services;

import com.evilcorp.trollquiz.services.dto.QuizQuestionDto;
import com.evilcorp.trollquiz.services.dto.ScoreDto;

import java.util.List;

public interface GameService {
    public QuizQuestionDto getGameQuestion();
    public boolean GetAnswer(long userId, long id, String answer);
    public List<ScoreDto> GetLeaderboard();
}
