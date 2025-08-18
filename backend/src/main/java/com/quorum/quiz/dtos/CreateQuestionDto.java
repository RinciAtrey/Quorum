package com.quorum.quiz.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateQuestionDto {
    private String title;
    private String description;
    private List<String> options;
    private LocalDateTime expiresAt;
}
