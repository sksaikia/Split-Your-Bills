package com.example.splityourbills.dto.invite;

public class InviteDTO {
    private Long spaceId;
    private String phoneNo;
    private String inviteName;

    public InviteDTO() {
    }

    public InviteDTO(Long spaceId, String phoneNo, String inviteName) {
        this.spaceId = spaceId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
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
}
