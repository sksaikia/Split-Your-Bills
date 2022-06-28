package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.dto.spacemember.NewSpaceMemberDTO;
import com.example.splityourbills.dto.spacemember.SetJoinedInvitedDTO;
import com.example.splityourbills.dto.spacemember.SpaceMembersDTO;
import com.example.splityourbills.entity.SpaceMembers;
import com.example.splityourbills.response.space.GetAllSpaceResponse;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.response.spaceMember.AddMemberToSpaceResponse;
import com.example.splityourbills.response.spaceMember.GetAllSpaceMembersResponse;
import com.example.splityourbills.response.spaceMember.SpaceMemberResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpaceMemberService{
    Integer addInviteOrPerson(SpaceMembersDTO spaceMembersDTO);
    GetAllSpaceMembersResponse getAllMembersbySpaceId(long spaceId);
    GetAllSpaceMembersResponse getAllSpacesByUserId(long userId);
    GetAllSpaceMembersResponse getAllSpacesByInviteId(long inviteId);
//    void deleteMemberInSpace(long spaceId,long userId);
//    void deleteInviteInSpace(long spaceId,long inviteId);
    Boolean deleteById(long id);
    AddMemberToSpaceResponse addOrInviteMemberToSpace(List<NewSpaceMemberDTO> spaceMemberDTOS);
    SpaceMemberResponse findBySpaceIdAndPersonId(Long spaceId, Long personId);
    SpaceMemberResponse findByParticularId(Long spaceMemberId);
    Boolean setJoinedForInvitedUser(SetJoinedInvitedDTO spaceMemberIds,Long userId);
}
