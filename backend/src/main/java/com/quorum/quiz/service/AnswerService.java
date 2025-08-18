package com.quorum.quiz.service;

import com.quorum.quiz.dtos.AnswerRequest;
import com.quorum.quiz.dtos.AnswerStatsDto;

import java.time.LocalDateTime;

public interface AnswerService {
    void submitAnswer(String shareCode, AnswerRequest req, String username);
    AnswerStatsDto getStats(String shareCode, LocalDateTime start, LocalDateTime end);
}
