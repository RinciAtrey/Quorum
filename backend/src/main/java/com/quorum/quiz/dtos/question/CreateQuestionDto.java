package com.quorum.quiz.dtos.question;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateQuestionDto {
    private String title;
    private LocalDateTime expiresAt;
    private List<OptionCreateDto> options;
}

