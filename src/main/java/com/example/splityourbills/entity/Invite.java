package com.example.splityourbills.entity;

import com.example.splityourbills.dto.invite.InviteDTO;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invites")
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invite_id")
    private Long inviteId;

    @Column(name="space_id")
    private Long spaceId;

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="invite_name")
    private String inviteName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastUpdated;

    @PrePersist
    private void onCreate(){
        lastUpdated = new Date();
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

    public Long getInviteId() {
        return inviteId;
    }

    public Invite() {
    }
    public Invite(Long spaceId,String phoneNo,String inviteName){
        this.spaceId = spaceId;
        this.phoneNo = phoneNo;
        this.inviteName = inviteName;
    }
    public Invite(InviteDTO inviteDTO){
        this.spaceId = inviteDTO.getSpaceId();
        this.inviteName = inviteDTO.getInviteName();
        this.phoneNo = inviteDTO.getPhoneNo();
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

}
