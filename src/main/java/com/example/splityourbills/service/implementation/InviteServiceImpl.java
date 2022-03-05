package com.example.splityourbills.service.implementation;

import com.example.splityourbills.dto.invite.InviteDTO;
import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.entity.Invite;
import com.example.splityourbills.entity.Space;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.repository.InviteRepository;
import com.example.splityourbills.repository.SpaceRepository;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.invite.GetAllInviteResponse;
import com.example.splityourbills.response.invite.InviteResponse;
import com.example.splityourbills.response.space.GetAllSpaceResponse;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.service.interfaces.InviteService;
import com.example.splityourbills.service.interfaces.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InviteServiceImpl implements InviteService {

    @Autowired
    InviteRepository inviteRepository;

    @Override
    public void addInvite(InviteDTO inviteDTO) {
//        Invite invite = getSpaceFromDTO(spaceDTO,userId);
//        inviteRepository.save(invite);
//        long spaceId = invite.getSpaceId();
//        return createSpaceResponse(spaceId,space);
    }

    @Override
    public InviteResponse getInviteByInviteId(Long inviteId) {




        return null;
    }

    @Override
    public InviteResponse getInviteBySpaceIdAndPhoneNo(Long spaceId, String phoneNo) {
        return null;
    }

    @Override
    public GetAllInviteResponse getAllInviteByInviteId(Long inviteId) {
        return null;
    }
}


