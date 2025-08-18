package com.quorum.quiz.dtos;

import lombok.Data;

@Data
public class OptionDto {
    private Long id;
    private String label;
    private int position;
    private long votes;
}
