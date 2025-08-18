package com.quorum.quiz.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime answeredAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User answeredBy;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private Option option;
}
