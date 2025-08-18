package com.quorum.quiz.dtos;

import lombok.Data;

import java.util.Map;

@Data
public class AnswerStatsDto {
    private Long questionId;
    private Map<Long, Long> counts;
    private long total;
}
