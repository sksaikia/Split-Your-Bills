package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.invite.InviteDTO;
import com.example.splityourbills.entity.Invite;
import com.example.splityourbills.response.invite.GetAllInviteResponse;
import com.example.splityourbills.response.invite.InviteResponse;

public interface InviteService {
    Boolean addInvite(Invite invite);
    InviteResponse getInviteByInviteId(Long inviteId);
    Long getInviteBySpaceIdAndPhoneNo(Long spaceId, String phoneNo);
    GetAllInviteResponse getAllInviteByInviteId(Long inviteId);
    InviteResponse getInviteByPhoneNo(String phoneNo);
}
