package com.quorum.quiz.repositories;

import com.quorum.quiz.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestion_IdOrderByPosition(Long questionId);
}
