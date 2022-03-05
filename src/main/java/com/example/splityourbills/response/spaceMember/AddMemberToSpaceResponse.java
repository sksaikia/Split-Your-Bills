package com.example.splityourbills.response.spaceMember;

public class AddMemberToSpaceResponse {
    public AddMemberToSpaceResponse(Integer registeredUsers, Integer invitedUsers, Integer errors,Integer ignored) {
        this.registeredUsers = registeredUsers;
        this.invitedUsers = invitedUsers;
        this.errors = errors;
        this.ignored = ignored;
    }

    private Integer registeredUsers;
    private Integer invitedUsers;
    private Integer errors;

    public Integer getIgnored() {
        return ignored;
    }

    public void setIgnored(Integer ignored) {
        this.ignored = ignored;
    }

    private Integer ignored;

    public Integer getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Integer registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public Integer getInvitedUsers() {
        return invitedUsers;
    }

    public void setInvitedUsers(Integer invitedUsers) {
        this.invitedUsers = invitedUsers;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }
}
