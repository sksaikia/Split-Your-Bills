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
    public Boolean addInvite(Invite invite) {
        inviteRepository.save(invite);
        return true;
    }

    private Invite getInviteFromDTO(InviteDTO inviteDTO) {
        Invite invite = new Invite(inviteDTO);
        return invite;
    }

    @Override
    public InviteResponse getInviteByInviteId(Long inviteId) {
        Optional<Invite> optionalInvite = inviteRepository.findByInviteId(inviteId);
        if (optionalInvite.isPresent()){
            Invite invite = optionalInvite.get();
            InviteResponse inviteResponse = new InviteResponse(invite.getInviteId(),invite.getSpaceId(),
                    invite.getPhoneNo(),invite.getInviteName(),invite.getLastUpdated());
            return inviteResponse;
        }else{
            throw new ResourceNotFoundException("Details with given invite id not found, inviteId: " + inviteId);
        }

    }

    @Override
    public Long getInviteBySpaceIdAndPhoneNo(Long spaceId, String phoneNo) {
        Optional<Invite> optionalInvite = inviteRepository.findBySpaceIdAndPhoneNo(spaceId, phoneNo);
        if (optionalInvite.isPresent()){
            Invite invite = optionalInvite.get();
            return invite.getInviteId();
        }else{
            return 0L;
         //   throw new ResourceNotFoundException("Invite with the following data not found: spaceId " + spaceId + " phoneNo : " + phoneNo);
        }
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


