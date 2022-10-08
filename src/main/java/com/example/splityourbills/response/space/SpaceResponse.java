package com.example.splityourbills.response.space;

import com.example.splityourbills.entity.Space;
import com.example.splityourbills.entity.User;
import com.example.splityourbills.response.auth.UserResponse;

import java.util.Date;

public class SpaceResponse {
    private Long spaceId;
    private Long personId;
    private String spaceName;
    private String spaceDescription;
    private Boolean isActive;
    private Date lastUpdated;
    private UserResponse userResponse;

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public void setSpaceDescription(String spaceDescription) {
        this.spaceDescription = spaceDescription;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public SpaceResponse(Long spaceId, Long personId, String spaceName, String spaceDescription, Boolean isActive,
                         Date lastUpdated, User userResponse) {
        this.spaceId = spaceId;
        this.personId = personId;
        this.spaceName = spaceName;
        this.spaceDescription = spaceDescription;
        this.isActive = isActive;
        this.lastUpdated = lastUpdated;
        if(userResponse!= null) {
            this.userResponse = new UserResponse(userResponse.getPhoneNo(),
                    userResponse.getUserName(),
                    userResponse.getUserId());
        }
    }

    public SpaceResponse() {
    }

    public SpaceResponse(Space space) {
        this.isActive = space.getActive();
        this.spaceId = space.getSpaceId();
        this.personId = space.getPersonId();
        this.spaceName = space.getSpaceName();
        this.spaceDescription = space.getSpaceDescription();
        this.lastUpdated = space.getLastUpdated();
        this.userResponse = getUserResponse();
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public String getSpaceDescription() {
        return spaceDescription;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
}
