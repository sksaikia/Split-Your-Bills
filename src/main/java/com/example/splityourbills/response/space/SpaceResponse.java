package com.example.splityourbills.response.space;

import java.util.Date;

public class SpaceResponse {
    private Long spaceId;
    private Long personId;
    private String spaceName;
    private String spaceDescription;
    private Boolean isActive;
    private Date lastUpdated;

    public SpaceResponse(Long spaceId, Long personId, String spaceName, String spaceDescription, Boolean isActive, Date lastUpdated) {
        this.spaceId = spaceId;
        this.personId = personId;
        this.spaceName = spaceName;
        this.spaceDescription = spaceDescription;
        this.isActive = isActive;
        this.lastUpdated = lastUpdated;
    }

    public SpaceResponse() {
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
