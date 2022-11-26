package com.example.splityourbills.service.implementation;

import com.example.splityourbills.exception.custom_exceptions.common.CustomDataConflictException;
import com.example.splityourbills.dto.auth.LoginRequest;
import com.example.splityourbills.dto.auth.SignUpRequest;
import com.example.splityourbills.entity.User;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.auth.JwtAuthenticationResponse;
import com.example.splityourbills.response.auth.LoginResponse;
import com.example.splityourbills.response.auth.UserResponse;
import com.example.splityourbills.response.invite.InviteResponse;
import com.example.splityourbills.response.spaceMember.GetAllSpaceMembersResponse;
import com.example.splityourbills.response.spaceMember.SpaceMemberResponse;
import com.example.splityourbills.security.JwtTokenProvider;
import com.example.splityourbills.service.interfaces.AuthService;
import com.example.splityourbills.service.interfaces.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@Transactional
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    InviteServiceImpl inviteService;

    @Autowired
    SpaceMemberServiceImpl spaceMemberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Override
    public URI registerUser(SignUpRequest signUpRequest) {
        if (userRepository.existsByPhoneNo(signUpRequest.getPhoneNo())) {
            throw new CustomDataConflictException("Phone number is already used ");
        }

        User user = new User(signUpRequest.getName(), signUpRequest.getPhoneNo(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userRepository.save(user);

        /**
         * Check whether that phoneNo is present on Invites table or not
         * */
        InviteResponse inviteResponse = inviteService.getInviteByPhoneNo(signUpRequest.getPhoneNo());

        if (inviteResponse.getPhoneNo() != null && inviteResponse.getPhoneNo().equals(signUpRequest.getPhoneNo())) {
            //So the phone no exists on the Invite DB
            long currentUserId = result.getUserId();
            //Get Space Member table data for particular invite id
            GetAllSpaceMembersResponse spaceMembersResponse = spaceMemberService.getAllSpacesByInviteId(inviteResponse.getInviteId());
            for (int i = 0; i < spaceMembersResponse.getSpaceMemberResponses().size(); i++) {
                SpaceMemberResponse currentSpaceMemberResponse
                        = spaceMembersResponse.getSpaceMemberResponses().get(i);
                spaceMemberService.updateSpaceMemberData(
                        currentSpaceMemberResponse, inviteResponse.getInviteId(), currentUserId, currentSpaceMemberResponse.getSpaceMemberId()
                );
            }
        }

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/users/{username}").buildAndExpand(result.getPhoneNo()).toUri();
        return location;
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhoneNo(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String username = "";
        Long currentUserId = 0L;
        if (userRepository.existsByPhoneNo(loginRequest.getPhoneNo())){
            Optional<User> optionalUser = userRepository.findByPhoneNo(loginRequest.getPhoneNo());
            if (optionalUser.isPresent()){
                 User user =   optionalUser.get();
                 username =  user.getUserName();
                 currentUserId =  user.getUserId();
            }else{
                //TODO - error fetching user data
            }
        }

        String jwt = tokenProvider.generateToken(authentication);
        LoginResponse loginResponse = new LoginResponse(new JwtAuthenticationResponse(jwt), new UserResponse( loginRequest.getPhoneNo(), username,currentUserId));

        return loginResponse;
    }
}
