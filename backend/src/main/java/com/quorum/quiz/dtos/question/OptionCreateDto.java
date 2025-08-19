package com.quorum.quiz.dtos.question;

import lombok.Data;

@Data
public class OptionCreateDto {
    private String label;
    //optional
    private Boolean isCorrect;
}
