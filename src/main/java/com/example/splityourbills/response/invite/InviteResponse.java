package com.example.splityourbills.response.invite;

import java.util.Date;

public class InviteResponse {
    private Long inviteId;
    private Long spaceId;
    private String phoneNo;
    private String inviteName;

    public InviteResponse() {
    }

    private Date lastUpdated;

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public InviteResponse(Long inviteId, Long spaceId, String phoneNo, String inviteName, Date lastUpdated) {
        this.inviteId = inviteId;
        this.spaceId = spaceId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
        this.lastUpdated = lastUpdated;
    }
}
