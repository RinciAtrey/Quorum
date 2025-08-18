package com.quorum.quiz.repositories;

import com.quorum.quiz.models.Question;
import com.quorum.quiz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByShareCode(String shareCode);

    List<Question> findByCreatedBy(User user);

    boolean existsByShareCode(String shareCode);

    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.options WHERE q.shareCode = :code")
    Optional<Question> findByShareCodeWithOptions(@Param("code") String code);
}
