package com.example.splityourbills.response.auth;

import com.example.splityourbills.entity.User;

public class UserResponse {
    private String phoneNo;
    private String username;
    private Long userId;

    public UserResponse(User user) {
        this.phoneNo = user.getPhoneNo();
        this.username = user.getUserName();
        this.userId = user.getUserId();
    }

    public Long getUserId() {
        return userId;
    }



    public String getPhoneNo() {
        return phoneNo;
    }

    public UserResponse(String phoneNo, String username,Long userId) {
        this.phoneNo = phoneNo;
        this.username = username;
        this.userId = userId;
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
