package com.quorum.quiz.serviceImpl;
import com.quorum.quiz.dtos.CreateQuestionDto;
import com.quorum.quiz.dtos.OptionDto;
import com.quorum.quiz.dtos.QuestionResponseDto;
import com.quorum.quiz.models.Option;
import com.quorum.quiz.models.Question;
import com.quorum.quiz.models.User;
import com.quorum.quiz.repositories.OptionRepository;
import com.quorum.quiz.repositories.QuestionRepository;
import com.quorum.quiz.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final SecureRandom random = new SecureRandom();

    @Override
    @Transactional
    public QuestionResponseDto createQuestion(CreateQuestionDto dto, User user) {
        Question q = new Question();
        q.setTitle(dto.getTitle());
        q.setExpiresAt(dto.getExpiresAt());
        q.setShareCode(generateUniqueShareCode());
        q.setIsOpen(true);
        q.setCreatedAt(LocalDateTime.now());
        q.setCreatedBy(user);
        questionRepository.save(q);

        List<Option> savedOptions = new ArrayList<>();
        int pos = 0;
        if (dto.getOptions() != null) {
            for (String label : dto.getOptions()) {
                Option o = new Option();
                o.setLabel(label);
                o.setPosition(pos++);
                o.setQuestion(q);
                savedOptions.add(optionRepository.save(o));
            }
        }

        return toResponseDto(q, savedOptions, user.getUsername());
    }

    @Override
    public List<QuestionResponseDto> getQuestionsByUser(User user) {
        return questionRepository.findByCreatedBy(user).stream()
                .map(q -> toResponseDto(q, Collections.emptyList(), user.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponseDto getPublicByShareCode(String shareCode) {
        Question q = questionRepository.findByShareCodeWithOptions(shareCode)
                .orElseThrow(() -> new NoSuchElementException("Question not found"));
        List<Option> opts = q.getOptions() == null ? Collections.emptyList() : q.getOptions();
        return toResponseDto(q, opts, q.getCreatedBy().getUsername());
    }

    private QuestionResponseDto toResponseDto(Question q, List<Option> options, String username) {
        QuestionResponseDto dto = new QuestionResponseDto();
        dto.setId(q.getId());
        dto.setTitle(q.getTitle());
        dto.setShareCode(q.getShareCode());
        dto.setIsOpen(q.getIsOpen());
        dto.setCreatedAt(q.getCreatedAt());
        dto.setExpiresAt(q.getExpiresAt());
        dto.setUsername(username);

        List<OptionDto> optionDtos = options.stream()
                .sorted(Comparator.comparingInt(o -> o.getPosition() == null ? 0 : o.getPosition()))
                .map(o -> {
                    OptionDto od = new OptionDto();
                    od.setId(o.getId());
                    od.setLabel(o.getLabel());
                    od.setPosition(o.getPosition() == null ? 0 : o.getPosition());
                    od.setVotes(0L);
                    return od;
                }).collect(Collectors.toList());
        dto.setOptions(optionDtos);
        return dto;
    }

    private String generateUniqueShareCode() {
        final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int attempt = 0; attempt < 8; attempt++) {
            StringBuilder sb = new StringBuilder(7);
            for (int i = 0; i < 7; i++) sb.append(chars.charAt(random.nextInt(chars.length())));
            String code = sb.toString();
            if (!questionRepository.existsByShareCode(code)) return code;
        }
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
