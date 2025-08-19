package com.quorum.quiz.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateQuestionDto {
    private String title;
    private LocalDateTime expiresAt;
    // list of option objects with label and optional isCorrect
    private List<OptionCreateDto> options;
}

