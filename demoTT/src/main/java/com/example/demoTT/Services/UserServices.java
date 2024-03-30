package com.example.demoTT.Services;

import com.example.demoTT.Models.User;
import com.example.demoTT.dto.Request.ForgotPassword;
import com.example.demoTT.dto.Request.LoginRequest;
import com.example.demoTT.dto.Request.RegisterRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.example.demoTT.dto.Response.TokenResponse;

public interface UserServices {
    TokenResponse login(LoginRequest loginRequest);

    MessageResponse register(RegisterRequest registerRequest);

    MessageResponse forgotPassword(ForgotPassword forgotPassword);

    User updateToken(String username);

    MessageResponse sendConfirmEmailRegister(String email);

    MessageResponse sendConfirmEmailForgotPassWord(String email);

    String confirmationCodeRegister();

    String confirmationCodeForgotPassWord();
}
