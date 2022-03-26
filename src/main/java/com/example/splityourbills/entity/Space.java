package com.example.splityourbills.entity;


import com.example.splityourbills.dto.space.SpaceDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="space")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "space_id")
    private Long spaceId;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "space_name")
    private String spaceName;

    @Column(name = "space_description")
    private String spaceDescription;

    @Column(name = "space_active")
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated",nullable = false)
    private Date lastUpdated;

    @PrePersist
    private void onCreate(){
        lastUpdated = new Date();
    }

    public List<SpaceMembers> getSpaceMembersList() {
        return spaceMembersList;
    }

    public void setSpaceMembersList(List<SpaceMembers> spaceMembersList) {
        this.spaceMembersList = spaceMembersList;
    }

    @OneToMany(mappedBy = "space",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<SpaceMembers> spaceMembersList;


    //TODO review this
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Boolean getActive() {
        return isActive;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Space() {

    }

    public Space(SpaceDTO spaceDTO,Long userId){
        this.setActive(true);
        this.setPersonId(userId);
        this.setSpaceName(spaceDTO.getSpaceName());
        this.setSpaceDescription(spaceDTO.getSpaceDescription());
    }

    public Space(Long spaceId, Long personId, String spaceName, String spaceDescription, Boolean isActive) {
        this.spaceId = spaceId;
        this.personId = personId;
        this.spaceName = spaceName;
        this.spaceDescription = spaceDescription;
        this.isActive = isActive;
    }

//    public Space(AddNewSpaceDTO spaceDTO, long userId) {
//        this.setSpaceName(spaceDTO.getSpaceName());
//        this.setSpaceDescription(spaceDTO.getSpaceDescription());
//        this.setPersonId(userId);
//        this.setActive(spaceDTO.getActive());
//    }

}
