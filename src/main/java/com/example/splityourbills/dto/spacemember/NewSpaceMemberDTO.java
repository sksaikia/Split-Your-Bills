package com.example.splityourbills.dto.spacemember;

public class NewSpaceMemberDTO {
    private Long spaceId;
    private String inviteName;
    private String phoneNo;

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public NewSpaceMemberDTO(Long spaceId, String phoneNo, String inviteName) {
        this.spaceId = spaceId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public NewSpaceMemberDTO() {
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

}
