package com.quorum.quiz.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuestionResponseDto {
    private Long id;
    private String title;
    private String shareCode;
    private Boolean isOpen;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private String username;
    private List<OptionDto> options;
}
