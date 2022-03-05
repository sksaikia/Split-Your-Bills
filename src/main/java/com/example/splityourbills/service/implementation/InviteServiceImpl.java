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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InviteServiceImpl implements InviteService {

    @Autowired
    InviteRepository inviteRepository;

    @Override
    public Boolean addInvite(InviteDTO inviteDTO) {
        Invite invite = getInviteFromDTO(inviteDTO);
        inviteRepository.save(invite);
        return true;
    }

    private Invite getInviteFromDTO(InviteDTO inviteDTO) {
        Invite invite = new Invite(inviteDTO);
        return invite;
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

//    private InviteResponse createInviteResponse(Invite invite) {
//        InviteResponse inviteResponse = new InviteResponse(invite.getInviteId(),invite.getSpaceId()
//        ,invite.getPhoneNo(),invite.getInviteName(),invite.getLastUpdated());
//        return inviteResponse;
//    }

}


