package com.example.splityourbills.model.auth;


import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String phoneNo;

    @NotBlank
    private String password;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
