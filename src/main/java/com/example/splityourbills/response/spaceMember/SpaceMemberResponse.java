package com.example.splityourbills.response.spaceMember;

import com.example.splityourbills.entity.SpaceMembers;
import com.example.splityourbills.entity.User;
import com.example.splityourbills.response.auth.UserResponse;
import com.example.splityourbills.response.invite.InviteResponse;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class SpaceMemberResponse {
    private Long spaceMemberId;
    private Long spaceId;
    private Long personId;
    private Boolean isJoined;
    private UserResponse userDetails;
    private Long inviteId;
    private InviteResponse invite;




    public UserResponse getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserResponse userDetails) {
        this.userDetails = userDetails;
    }

    public void setSpaceMemberId(Long spaceMemberId) {
        this.spaceMemberId = spaceMemberId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public void setJoined(Boolean joined) {
        isJoined = joined;
    }

    public InviteResponse getInvite() {
        return invite;
    }

    public void setInvite(InviteResponse invite) {
        this.invite = invite;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public SpaceMemberResponse() {
    }

    private Date lastUpdated;

    public Long getSpaceMemberId() {
        return spaceMemberId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public Long getPersonId() {
        return personId;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public Boolean getJoined() {
        return isJoined;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public SpaceMemberResponse(Long spaceMemberId, Long spaceId, Long personId,
                               Long inviteId, Boolean isJoined, Date lastUpdated, SpaceMembers spaceMembers) {
        this.spaceMemberId = spaceMemberId;
        this.spaceId = spaceId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.isJoined = isJoined;
        this.lastUpdated = lastUpdated;
        this.invite = new InviteResponse(spaceMembers.getInvite());
        this.userDetails = new UserResponse(spaceMembers.getUser());
    }
}
