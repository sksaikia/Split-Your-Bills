package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.auth.LoginRequest;
import com.example.splityourbills.dto.auth.SignUpRequest;
import com.example.splityourbills.response.auth.LoginResponse;

import java.net.URI;

public interface AuthService {
     URI registerUser(SignUpRequest signUpRequest);
     LoginResponse loginUser(LoginRequest loginRequest);
}
