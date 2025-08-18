package com.quorum.quiz.controllers;

import com.quorum.quiz.dtos.AnswerRequest;
import com.quorum.quiz.dtos.AnswerStatsDto;
import com.quorum.quiz.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/answers")
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{shareCode}")
    public ResponseEntity<Void> submitAnswer(@PathVariable String shareCode,
                                             @RequestBody AnswerRequest req,
                                             Principal principal){
        answerService.submitAnswer(shareCode, req, principal.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stats/{shareCode}")
    public ResponseEntity<AnswerStatsDto> getStats(@PathVariable String shareCode){
        return ResponseEntity.ok(answerService.getStats(shareCode, null, null));
    }
}
