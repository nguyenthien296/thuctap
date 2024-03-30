package com.example.demoTT.Controller;

import com.example.demoTT.Models.User;
import com.example.demoTT.Repository.UserRepo;
import com.example.demoTT.Services.Impl.UserServicesImpl;
import com.example.demoTT.dto.Request.ForgotPassword;
import com.example.demoTT.dto.Request.LoginRequest;
import com.example.demoTT.dto.Request.RegisterRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.example.demoTT.dto.Response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private UserRepo userRepo;
    @PostMapping("register")
    public ResponseEntity<MessageResponse> register( @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userServices.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("sendemailregister")
    public ResponseEntity<MessageResponse> sendConfirmEmailRegister( @RequestParam("email") String email) {
        return new ResponseEntity<>(userServices.sendConfirmEmailRegister(email), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userServices.login(loginRequest), HttpStatus.OK);
    }
    @PutMapping("forgotpassword")
    public ResponseEntity<MessageResponse> forgotPassword(@Valid @RequestBody ForgotPassword ForgotPassword) {
        return new ResponseEntity<>(userServices.forgotPassword(ForgotPassword), HttpStatus.OK);
    }
    @PostMapping("sendemailforgotpassword")
    public ResponseEntity<MessageResponse> sendConfirmEmailForgotPassWord(@Valid @RequestParam("email") String email) {
        return new ResponseEntity<>(userServices.sendConfirmEmailForgotPassWord(email), HttpStatus.OK);
    }

    @GetMapping("showusers")
    public Set<User> getAll() {
        return new HashSet<>(userRepo.findAll());
    }
}
