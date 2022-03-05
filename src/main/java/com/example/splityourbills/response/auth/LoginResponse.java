package com.example.splityourbills.response.auth;

public class LoginResponse {

    private JwtAuthenticationResponse jwt;
    public UserResponse userDetails;


    public JwtAuthenticationResponse getJwt() {
        return jwt;
    }

    public LoginResponse(JwtAuthenticationResponse jwt,UserResponse userResponse) {
        this.jwt = jwt;
        this.userDetails = userResponse;
    }

    public void setJwt(JwtAuthenticationResponse jwt) {
        this.jwt = jwt;
    }

}
