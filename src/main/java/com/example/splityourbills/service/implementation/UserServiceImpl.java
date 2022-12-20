package com.example.splityourbills.service.implementation;

import com.example.splityourbills.entity.User;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.security.CurrentUser;
import com.example.splityourbills.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl{

    @Autowired
    UserRepository userRepository;

    public void updateProfilePicture(String url, @CurrentUser UserPrincipal currentUser) {
        Optional<User> optional = userRepository.findById(currentUser.getId());
        if (optional.isPresent()) {
            User user = optional.get();
            user.setProfilePic(url);
            userRepository.save(user);
        }
    }

}


