package com.quorum.quiz.repositories;

import com.quorum.quiz.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    long countByQuestion_IdAndOption_Id(Long questionId, Long optionId);

    boolean existsByQuestion_IdAndAnsweredBy_Id(Long questionId, Long userId);
}
