package com.example.splityourbills.response.spaceMember;

import java.util.List;

public class GetAllSpaceMembersResponse {
    private List<SpaceMemberResponse> spaceMemberResponses;
    private Integer totalMembers;

    public GetAllSpaceMembersResponse(List<SpaceMemberResponse> spaceMemberResponses, Integer totalMembers) {
        this.spaceMemberResponses = spaceMemberResponses;
        this.totalMembers = totalMembers;
    }

    public List<SpaceMemberResponse> getSpaceMemberResponses() {
        return spaceMemberResponses;
    }

    public void setSpaceMemberResponses(List<SpaceMemberResponse> spaceMemberResponses) {
        this.spaceMemberResponses = spaceMemberResponses;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public GetAllSpaceMembersResponse() {
    }
}
