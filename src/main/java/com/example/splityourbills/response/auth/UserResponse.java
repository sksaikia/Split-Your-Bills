package com.example.splityourbills.response.auth;

public class UserResponse {
    private String phoneNo;
    private String username;

    public String getPhoneNo() {
        return phoneNo;
    }

    public UserResponse(String phoneNo, String username) {
        this.phoneNo = phoneNo;
        this.username = username;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
