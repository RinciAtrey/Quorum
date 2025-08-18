package com.quorum.quiz.serviceImpl;

import com.quorum.quiz.dtos.AnswerRequest;
import com.quorum.quiz.dtos.AnswerStatsDto;
import com.quorum.quiz.models.Answer;
import com.quorum.quiz.models.Option;
import com.quorum.quiz.models.Question;
import com.quorum.quiz.models.User;
import com.quorum.quiz.repositories.AnswerRepository;
import com.quorum.quiz.repositories.OptionRepository;
import com.quorum.quiz.repositories.QuestionRepository;
import com.quorum.quiz.service.AnswerService;
import com.quorum.quiz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final AnswerRepository answerRepository;
    private final UserService userService;

    @Override
    @Transactional
    public void submitAnswer(String shareCode, AnswerRequest req, String username) {
        Question q = questionRepository.findByShareCode(shareCode)
                .orElseThrow(() -> new NoSuchElementException("Question not found"));
        if (!Boolean.TRUE.equals(q.getIsOpen())) throw new IllegalStateException("Question is closed");

        Option opt = optionRepository.findById(req.getOptionId())
                .orElseThrow(() -> new NoSuchElementException("Option not found"));

        if (!opt.getQuestion().getId().equals(q.getId())) {
            throw new IllegalArgumentException("Option does not belong to the question");
        }

        User user = null;
        if (username != null) {
            user = userService.findByUsername(username);
            if (user != null && answerRepository.existsByQuestion_IdAndAnsweredBy_Id(q.getId(), user.getId())) {
                throw new IllegalStateException("User already voted");
            }
        }

        Answer a = new Answer();
        a.setQuestion(q);
        a.setOption(opt);
        a.setAnsweredBy(user);
        a.setAnsweredAt(LocalDateTime.now());
        answerRepository.save(a);
    }

    @Override
    public AnswerStatsDto getStats(String shareCode, LocalDateTime start, LocalDateTime end) {
        Question q = questionRepository.findByShareCode(shareCode)
                .orElseThrow(() -> new NoSuchElementException("Question not found"));

        List<Option> options = optionRepository.findByQuestion_IdOrderByPosition(q.getId());
        Map<Long, Long> counts = new LinkedHashMap<>();
        long total = 0;
        for (Option o : options) {
            long c;
            c = answerRepository.countByQuestion_IdAndOption_Id(q.getId(), o.getId());
            counts.put(o.getId(), c);
            total += c;
        }
        AnswerStatsDto dto = new AnswerStatsDto();
        dto.setQuestionId(q.getId());
        dto.setCounts(counts);
        dto.setTotal(total);
        return dto;
    }
}
