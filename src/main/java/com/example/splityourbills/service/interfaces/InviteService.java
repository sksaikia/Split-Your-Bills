package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.invite.InviteDTO;
import com.example.splityourbills.response.invite.GetAllInviteResponse;
import com.example.splityourbills.response.invite.InviteResponse;

public interface InviteService {
    void addInvite(InviteDTO inviteDTO);
    InviteResponse getInviteByInviteId(Long inviteId);
    InviteResponse getInviteBySpaceIdAndPhoneNo(Long spaceId, String phoneNo);
    GetAllInviteResponse getAllInviteByInviteId(Long inviteId);
}
