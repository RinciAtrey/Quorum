package com.quorum.quiz.dtos.question;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL) //omits nulls in JSON (so public view won't include isCorrect)
@Data
public class OptionDto {
    private Long id;
    private String label;
    private int position;
    private long votes;
    //will be non-null only when the user chooses to include it
    private Boolean isCorrect;
}
