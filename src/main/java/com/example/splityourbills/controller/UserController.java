package com.example.splityourbills.controller;


import com.example.splityourbills.model.auth.UserSummary;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.security.CurrentUser;
import com.example.splityourbills.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }
    @GetMapping("/user/me/id")
    public Long getCurrentUserId(@CurrentUser UserPrincipal currentUser) {
        UserSummary summary =  getCurrentUser(currentUser);
        long userId = summary.getId();
        return userId;
    }


}
