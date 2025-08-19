package com.quorum.quiz.service;

import com.quorum.quiz.dtos.question.CreateQuestionDto;
import com.quorum.quiz.dtos.question.QuestionResponseDto;
import com.quorum.quiz.models.User;

import java.util.List;

public interface QuestionService {
    QuestionResponseDto createQuestion(CreateQuestionDto dto, User user);
    List<QuestionResponseDto> getQuestionsByUser(User user);
    QuestionResponseDto getPublicByShareCode(String shareCode);
}
