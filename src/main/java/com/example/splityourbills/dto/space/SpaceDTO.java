package com.example.splityourbills.dto.space;

import com.example.splityourbills.entity.Space;

public class SpaceDTO {
    private String spaceName;
    private String spaceDescription;

    public SpaceDTO(Space space) {
       this.setSpaceName(space.getSpaceName());
       this.setSpaceDescription(space.getSpaceDescription());
    }

    public SpaceDTO() {
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceDescription() {
        return spaceDescription;
    }

    public void setSpaceDescription(String spaceDescription) {
        this.spaceDescription = spaceDescription;
    }
}
