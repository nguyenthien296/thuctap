package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Decentralization;
import com.example.demoTT.Models.ERole;
import com.example.demoTT.Models.User;
import com.example.demoTT.Models.UserDetailsCustom;
import com.example.demoTT.Repository.DecentralizationRepo;
import com.example.demoTT.Repository.UserRepo;
import com.example.demoTT.Services.UserServices;
import com.example.demoTT.Unil.CodeGenerator;
import com.example.demoTT.dto.Request.ChangePasswordRequest;
import com.example.demoTT.dto.Request.ForgotPassword;
import com.example.demoTT.dto.Request.LoginRequest;
import com.example.demoTT.dto.Request.RegisterRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import com.example.demoTT.dto.Response.TokenResponse;
import com.example.demoTT.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    public UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private DecentralizationRepo decentralizationRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private AuthenticationManager authenticationManager;


    private Map<String, String> codeMap = new HashMap<>();

    @Override
    public MessageResponse register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepo.findByUserName(registerRequest.getUsername());
        if (optionalUser.isPresent()) {
            return MessageResponse.builder().message("tai khoan da ton tai").build();
        }
        Optional<Decentralization> quyenHan = decentralizationRepo.findByAuthorityName(ERole.USER);
        if (!checkCode(registerRequest.getConfirmCode(),registerRequest.getEmail())){
            return MessageResponse.builder().message("Ma khong dung").build();
        }
        User user = User
                .builder()
                .userName(registerRequest.getUsername())
                .passwWord(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .decentralization(quyenHan.get())
                .build();
        try{
            userRepo.save(user);
            return MessageResponse.builder().message("Dang ky thanh cong").build();
        }catch (Exception e){
            return MessageResponse.builder().message("Dang ky that bai").build();
        }
    }

    @Override
    public MessageResponse sendConfirmEmailRegister(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Xac nhan dang ky tai khoan");
        String confirmationCode = confirmationCodeRegister();
        simpleMailMessage.setText("Ma xac nhan cua ban la " + confirmationCode);
        javaMailSender.send(simpleMailMessage);
        codeMap.put(confirmationCode, email);
        return MessageResponse.builder().message("Gui ma thanh cong").build();
    }

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()));
        Optional<User> findByUsername = userRepo.findByUserName(loginRequest.getUsername()
        );
        if (findByUsername.isPresent()) {
            User refreshToken = updateToken(loginRequest.getUsername());
            String jwtToken = jwtService.generateToken(new UserDetailsCustom(findByUsername.get()));
            return TokenResponse
                    .builder()
                    .accessToken(jwtToken)
                    .token(refreshToken.getResetPasswordToken())
                    .role(findByUsername.get().getRole().getRoleName().name())
                    .message("Login Thành Công")
                    .build();
        } else {
            return TokenResponse.builder()
                    .message("Sai username hoặc password")
                    .build();
        }
    }
    @Override
    public MessageResponse forgotPassword(ForgotPassword forgotPassword) {
        Optional<User> optionalUser = userRepo.findByEmail(forgotPassword.getEmail());
        if (optionalUser.isEmpty()) {
            return MessageResponse.builder().message("Email không tồn tại").build();
        }
        optionalUser.get().setPasswWord(forgotPassword.getPassword());
        if (!forgotPassword.getEnterPassword().equals(forgotPassword.getPassword())) {
            return MessageResponse.builder().message("Mật khẩu không khớp").build();
        }
        if (!checkCode(forgotPassword.getConfirmCode(), forgotPassword.getEmail())) {
            return MessageResponse.builder().message("Mã không khớp").build();
        }
        optionalUser.get().setPasswWord(passwordEncoder.encode(forgotPassword.getPassword()));
        userRepo.save(optionalUser.get());
        return MessageResponse.builder().message("Thay đổi mật khẩu thành công").build();
    }
    @Override
    public MessageResponse sendConfirmEmailForgotPassWord(String email) {
        String confirmationCode = confirmationCodeForgotPassWord();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Mã xác nhận quên mật khẩu của bạn là:");
        simpleMailMessage.setText("Mã xác nhận của bạn là   " + confirmationCode);
        javaMailSender.send(simpleMailMessage);
        codeMap.put(confirmationCode, email);
        return MessageResponse.builder().message("Send mã thành công").build();
    }

    public boolean checkCode(String code, String email) {
        return codeMap.containsKey(code) && codeMap.get(code).equals(email);
    }
    @Override
    public String confirmationCodeRegister() {
        return CodeGenerator.generateRandomCode(6);
    }
    @Override
    public String confirmationCodeForgotPassWord() {
        return CodeGenerator.generateRandomCode(15);
    }
    @Override
    public User updateToken(String username) {
        Optional<User> findByUsername = userRepo.findByUserName(username);
        findByUsername.get().setResetPasswordToken(UUID.randomUUID().toString());
        findByUsername.get().setResetPasswordTokenExpiry(LocalDate.from(LocalDateTime.now().plusMinutes(600000)));
        return userRepo.save(findByUsername.get());
    }
}
