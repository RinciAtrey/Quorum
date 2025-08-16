package com.quorum.quiz.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtAuthenticationResponse {
    private String Token;
}
