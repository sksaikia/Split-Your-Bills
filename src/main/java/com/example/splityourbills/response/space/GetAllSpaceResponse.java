package com.example.splityourbills.response.space;

import java.util.List;

public class GetAllSpaceResponse {

    private List<SpaceResponse> spaces;
    private Integer totalSpaces;

    public GetAllSpaceResponse() {
    }

    public List<SpaceResponse> getSpaceResponse() {
        return spaces;
    }

    public void setSpaceResponse(List<SpaceResponse> spaceResponse) {
        this.spaces = spaceResponse;
    }

    public Integer getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(Integer totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public GetAllSpaceResponse(List<SpaceResponse> spaceResponse, Integer totalSpaces) {
        this.spaces = spaceResponse;
        this.totalSpaces = totalSpaces;
    }
}
