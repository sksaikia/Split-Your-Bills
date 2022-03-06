package com.example.splityourbills.controller;

import com.example.splityourbills.dto.auth.ApiResponse;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @GetMapping("/abs")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(new ApiResponse(true,"SUUUUUCUCUUCESSS", HttpStatus.OK));

    }

}
