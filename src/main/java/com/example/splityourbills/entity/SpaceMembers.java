package com.example.splityourbills.entity;

import com.example.splityourbills.dto.spacemember.SpaceMembersDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="space_members")
public class SpaceMembers{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="space_member_id")
    private Long spaceMemberId;

    @Column(name="space_id")
    private Long spaceId;

    @Column(name="person_id")
    private Long personId;

    @Column(name="invite_id")
    private Long inviteId;

    @Column(name="is_joined")
    private Boolean isJoined;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated",nullable = false)
    private Date lastUpdated;

    @PrePersist
    private void onCreate(){
        lastUpdated = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "user_id",insertable = false,updatable = false)
    private User user;

    public Invite getInvites() {
        return invite;
    }

    public void setInvites(Invite invite) {
        this.invite = invite;
    }

    @ManyToOne
    @JoinColumn(name = "invite_id", referencedColumnName = "invite_id",insertable = false,updatable = false)
    private Invite invite;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SpaceMembers() {
    }

    public SpaceMembers(Long spaceId,Boolean isUser,Long inviteId,Long personId) {
        this.spaceId = spaceId;
        this.inviteId = inviteId;
        this.isJoined  = isUser;
        this.personId = personId;
    }

    public Long getSpaceMemberId() {
        return spaceMemberId;
    }

    public void setSpaceMemberId(Long spaceMemberId) {
        this.spaceMemberId = spaceMemberId;
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

    public Boolean getJoined() {
        return isJoined;
    }

    public void setJoined(Boolean joined) {
        isJoined = joined;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }
}

