package com.example.demoTT.dto.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {
    private String accessToken;

    private String token;

    private String role;

    private String message;
}
