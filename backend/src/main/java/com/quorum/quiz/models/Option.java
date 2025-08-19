package com.quorum.quiz.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "options")
@Data
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private Boolean isCorrect= false;

    @Column(name = "position_idx")
    private Integer position = 0;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;


}
