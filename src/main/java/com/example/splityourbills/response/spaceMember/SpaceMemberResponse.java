package com.example.splityourbills.response.spaceMember;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class SpaceMemberResponse {
    private Long spaceMemberId;
    private Long spaceId;
    private Long personId;
    private Long inviteId;
    private Boolean isJoined;

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

    public SpaceMemberResponse(Long spaceMemberId, Long spaceId, Long personId, Long inviteId, Boolean isJoined, Date lastUpdated) {
        this.spaceMemberId = spaceMemberId;
        this.spaceId = spaceId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.isJoined = isJoined;
        this.lastUpdated = lastUpdated;
    }
}
