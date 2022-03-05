package com.example.splityourbills.response.invite;

import java.util.List;

public class GetAllInviteResponse {
    public GetAllInviteResponse() {
    }

    private List<InviteResponse> invites;
    private Integer totalInvites;

    public List<InviteResponse> getInvites() {
        return invites;
    }

    public void setInvites(List<InviteResponse> invites) {
        this.invites = invites;
    }

    public Integer getTotalInvites() {
        return totalInvites;
    }

    public void setTotalInvites(Integer totalInvites) {
        this.totalInvites = totalInvites;
    }

    public GetAllInviteResponse(List<InviteResponse> invites, Integer totalInvites) {
        this.invites = invites;
        this.totalInvites = totalInvites;
    }
}
