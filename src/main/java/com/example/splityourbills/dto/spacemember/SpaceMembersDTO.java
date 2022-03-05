package com.example.splityourbills.dto.spacemember;

public class SpaceMembersDTO {
    private Long spaceId;
    private Long personId;
    private String inviteName;
    private Long inviteId;
    private String phoneNo;

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }



    public SpaceMembersDTO(Long spaceId, Long personId, Long inviteId, String phoneNo, String inviteName) {
        this.spaceId = spaceId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
    }



    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public SpaceMembersDTO(Long spaceId, Long personId, Long inviteId, String phoneNo) {
        this.spaceId = spaceId;
        this.personId = personId;
        this.inviteId = inviteId;
        this.phoneNo = phoneNo;
    }

    public SpaceMembersDTO() {
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public SpaceMembersDTO(Long spaceId, String phoneNo, String inviteName) {
        this.spaceId = spaceId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
    }
}
