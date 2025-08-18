package com.quorum.quiz.controllers;

import com.quorum.quiz.dtos.CreateQuestionDto;
import com.quorum.quiz.dtos.QuestionResponseDto;
import com.quorum.quiz.models.User;
import com.quorum.quiz.service.QuestionService;
import com.quorum.quiz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<QuestionResponseDto> createQuestion(@RequestBody CreateQuestionDto dto, Principal principal){
        User user = userService.findByUsername(principal.getName());
        QuestionResponseDto created = questionService.createQuestion(dto, user);
        return ResponseEntity.ok(created);
    }

    // public get by share code
    @GetMapping("/share/{code}")
    public ResponseEntity<QuestionResponseDto> getByShare(@PathVariable String code){
        return ResponseEntity.ok(questionService.getPublicByShareCode(code));
    }
}
