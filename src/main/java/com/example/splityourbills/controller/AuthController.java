package com.example.splityourbills.controller;

import com.example.splityourbills.exception.custom_exceptions.auth.AuthenticationException;
import com.example.splityourbills.exception.custom_exceptions.common.CustomDataConflictException;
import com.example.splityourbills.model.auth.ApiResponse;
import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.model.auth.LoginRequest;
import com.example.splityourbills.model.auth.SignUpRequest;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.auth.LoginResponse;
import com.example.splityourbills.security.JwtTokenProvider;
import com.example.splityourbills.service.implementation.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    AuthServiceImpl authServiceImpl;

    @PostMapping("/login")
    public BaseApiResponse loginUser(@Valid @RequestBody LoginRequest loginRequest){

        LoginResponse loginResponse =  authServiceImpl.loginUser(loginRequest);
        if (loginResponse!=null) {
            return baseApiBuilderHelper(true,loginResponse);
        } else
            throw new CustomDataConflictException("Bad Credentials for user log in");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){

        URI location =  authServiceImpl.registerUser(signUpRequest);
        if (location!=null){
            return ResponseEntity.created(location).body(new ApiResponse(true,"User registered", HttpStatus.CREATED));
        }else{
            throw new AuthenticationException("Unexpected problems with registering the user");
        }

    }

    private BaseApiResponse baseApiBuilderHelper(Boolean success,LoginResponse data){
        BaseApiResponse<LoginResponse> baseApiResponse = new BaseApiResponse(success);
        if (success){
            baseApiResponse.setData(data);
        }else{
            baseApiResponse.setError(null);
        }
        return baseApiResponse;
    }

}
