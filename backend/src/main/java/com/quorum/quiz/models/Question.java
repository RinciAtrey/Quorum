package com.quorum.quiz.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "share_code", nullable = false, unique = true, length = 32)
    private String shareCode;

    private Boolean isOpen = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Option> options;
}
