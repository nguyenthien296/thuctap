package com.example.demoTT.dto.Request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {
    @NotBlank(message = "Khong duoc de trong username")
    private String username;

    @NotBlank(message = "Khong duoc de trong password")
    private String password;
}
