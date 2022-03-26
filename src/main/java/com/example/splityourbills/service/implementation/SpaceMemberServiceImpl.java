package com.example.splityourbills.service.implementation;

import com.example.splityourbills.common.Constants;
import com.example.splityourbills.dto.spacemember.NewSpaceMemberDTO;
import com.example.splityourbills.dto.spacemember.SpaceMembersDTO;
import com.example.splityourbills.entity.Invite;
import com.example.splityourbills.entity.Space;
import com.example.splityourbills.entity.SpaceMembers;
import com.example.splityourbills.entity.User;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.repository.SpaceMemberRepository;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.spaceMember.AddMemberToSpaceResponse;
import com.example.splityourbills.response.spaceMember.GetAllSpaceMembersResponse;
import com.example.splityourbills.response.spaceMember.SpaceMemberResponse;
import com.example.splityourbills.service.interfaces.SpaceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpaceMemberServiceImpl implements SpaceMemberService {


    @Autowired
    private SpaceMemberRepository spaceMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InviteServiceImpl inviteService;

    @Override
    public Integer addInviteOrPerson(SpaceMembersDTO spaceMembersDTO) {
        Long currentUserId = 0L;
        String phoneNo = spaceMembersDTO.getPhoneNo();
        if (userRepository.existsByPhoneNo(phoneNo)){
            Optional<User> optionalUser =  userRepository.findByPhoneNo(phoneNo);
            if (optionalUser.isPresent()){
                User currentUser = optionalUser.get();
                currentUserId = currentUser.getUserId();

                Optional<SpaceMembers> optionalSpaceMembers = spaceMemberRepository.
                        findBySpaceIdAndPersonId(spaceMembersDTO.getSpaceId(),currentUserId);

                if(!optionalSpaceMembers.isPresent()){
                    SpaceMembers spaceMembers = getSpaceMembersFromDTO(spaceMembersDTO.getSpaceId(),true,-1L,currentUserId);
                    spaceMemberRepository.save(spaceMembers);
                    return Constants.REGISTERD_USER;
                }else{
                    return Constants.IGNORED;
                }

            }else{

            }
        }else{
            Long spaceId = spaceMembersDTO.getSpaceId();

            long inviteId =  inviteService.getInviteBySpaceIdAndPhoneNo(spaceId,phoneNo);
            if(inviteId!=0){
                return Constants.IGNORED;
            }
            Invite newInvite = new Invite(spaceId,phoneNo,spaceMembersDTO.getInviteName());
            inviteService.addInvite(newInvite);

            inviteId =  inviteService.getInviteBySpaceIdAndPhoneNo(spaceId,phoneNo);

            SpaceMembers spaceMembers = getSpaceMembersFromDTO(spaceMembersDTO.getSpaceId(),false,inviteId,-1L);
            spaceMemberRepository.save(spaceMembers);

            return Constants.INVITED_USER;
        }

        return Constants.ADDING_MEMBER_ERROR;
    }

    private SpaceMembers getSpaceMembersFromDTO(Long spaceId, boolean isUser, Long inviteId, Long userId) {
        SpaceMembers spaceMembers = new SpaceMembers(spaceId,isUser,inviteId,userId);
        return spaceMembers;
    }


    @Override
    public GetAllSpaceMembersResponse getAllMembersbySpaceId(long spaceId) {
        Optional<List<SpaceMembers>> optionalSpaceMemberList =
                spaceMemberRepository.findAllBySpaceId(spaceId);
        if (optionalSpaceMemberList.isPresent()){
            List<SpaceMemberResponse> spaceMemberResponseList = convertSpaceMembersToResponse(optionalSpaceMemberList.get());
            return createAllSpaceMembersResponse(spaceMemberResponseList,spaceMemberResponseList.size());

        }else{
            throw new ResourceNotFoundException("Member details not found with that particular spaceId : " + spaceId);
        }
    }

    private List<SpaceMemberResponse> convertSpaceMembersToResponse(List<SpaceMembers> spaceMembers) {
        List<SpaceMemberResponse> spaceMemberResponseList = new ArrayList<>();
        for (SpaceMembers spaceMember : spaceMembers){
            spaceMemberResponseList.add(getSpaceMemberResponseFromSpaceMember(spaceMember));
        }
        return spaceMemberResponseList;
    }

    private SpaceMemberResponse getSpaceMemberResponseFromSpaceMember(SpaceMembers spaceMember) {
        SpaceMemberResponse spaceMemberResponse = new SpaceMemberResponse(spaceMember.getSpaceMemberId(),spaceMember.getSpaceId()
        ,spaceMember.getPersonId(),spaceMember.getInviteId(),spaceMember.getJoined(),spaceMember.getLastUpdated(),spaceMember);
        return spaceMemberResponse;
    }

    private GetAllSpaceMembersResponse createAllSpaceMembersResponse( List<SpaceMemberResponse> spaceMemberResponseList,int size){
        GetAllSpaceMembersResponse getAllSpaceMembersResponse = new GetAllSpaceMembersResponse(spaceMemberResponseList,size);
        return getAllSpaceMembersResponse;
    }

    @Override
    public GetAllSpaceMembersResponse getAllSpacesByUserId(long userId) {
        Optional<List<SpaceMembers>> optionalSpaceMemberList =
                spaceMemberRepository.findAllByPersonId(userId);
        if (optionalSpaceMemberList.isPresent()){
            List<SpaceMemberResponse> spaceMemberResponseList = convertSpaceMembersToResponse(optionalSpaceMemberList.get());
            return createAllSpaceMembersResponse(spaceMemberResponseList,spaceMemberResponseList.size());

        }else{
            throw new ResourceNotFoundException("Member details not found with that particular userId : " + userId);
        }

    }

    @Override
    public GetAllSpaceMembersResponse getAllSpacesByInviteId(long inviteId) {
        Optional<List<SpaceMembers>> optionalSpaceMemberList =
                spaceMemberRepository.findAllByInviteId(inviteId);
        if (optionalSpaceMemberList.isPresent()){
            List<SpaceMemberResponse> spaceMemberResponseList = convertSpaceMembersToResponse(optionalSpaceMemberList.get());
            return createAllSpaceMembersResponse(spaceMemberResponseList,spaceMemberResponseList.size());

        }else{
            throw new ResourceNotFoundException("Member details not found with that particular inviteId : " + inviteId);
        }
    }

    @Override
    public Boolean deleteById(long id) {
        Optional<SpaceMembers> optionalSpaceMembers = spaceMemberRepository.findById(id);
        if (optionalSpaceMembers.isPresent()){
            spaceMemberRepository.deleteById(id);
            return true;
        }else{
            throw new ResourceNotFoundException("Member details not found with that particular id : " + id);
        }
    }

//    @Override
//    public void deleteMemberInSpace(long spaceId, long personId) {
//        Optional<SpaceMembers> optionalSpaceMembers =
//                spaceMemberRepository.findBySpaceIdAndPersonId(spaceId,personId);
//
//        if (optionalSpaceMembers.isPresent()){
//            long id = optionalSpaceMembers.get().getSpaceMemberId();
//            //TODO how to throw exception
//            if (spaceMemberRepository.existsBySpaceId(id)){
//                spaceMemberRepository.deleteById(id);
//            }
//            else{
//                throw new ResourceNotFoundException("Space with the given id not found, spaceMember id : " + id);
//            }
//        }else{
//            throw new ResourceNotFoundException("Space with the given ids not found, spaceId : "
//                    + spaceId + " and person id : " + personId);
//        }
//    }

//    //TODO implement this
//    @Override
//    public void deleteInviteInSpace(long spaceId, long inviteId) {
////        Optional<SpaceMembers> optionalSpaceMembers =
////                spaceMemberRepository.findAllByInviteId(inviteId);
////
////        if (optionalSpaceMembers.isPresent()){
////            long id = optionalSpaceMembers.get().getId();
////            long inv = optionalSpaceMembers.get().getInviteId();
////            spaceMembersRepository.deleteById(id);
////            inviteRepository.deleteById(inv);
////        }else{
////            //TODO throw exception
////        }
//    }

    //TODO add some exception in case of error
    public void addSpaceCreatorToMemberList(SpaceMembersDTO spaceMembersDTO) {
        SpaceMembers spaceMembers = new SpaceMembers(spaceMembersDTO.getSpaceId(),true,
                spaceMembersDTO.getInviteId(), spaceMembersDTO.getPersonId());
        spaceMemberRepository.save(spaceMembers);
    }

    public AddMemberToSpaceResponse addOrInviteMemberToSpace(List<NewSpaceMemberDTO> spaceMemberDTOS) {

        int registeredUsers = 0;
        int invitedUsers = 0;
        int failures = 0;
        int ignored = 0;

        for(NewSpaceMemberDTO spaceMemberDTO : spaceMemberDTOS){
            SpaceMembersDTO spaceMembersDTO = new SpaceMembersDTO(
                    spaceMemberDTO.getSpaceId(),
                    spaceMemberDTO.getPhoneNo(),
                    spaceMemberDTO.getInviteName()
            );
            int result =  addInviteOrPerson(spaceMembersDTO);
            if (result == Constants.REGISTERD_USER){
                registeredUsers++;
            }else if (result == Constants.INVITED_USER){
                invitedUsers++;
            }else if (result == Constants.ADDING_MEMBER_ERROR){
                failures++;
            }else{
                ignored++;
            }
        }

        return new AddMemberToSpaceResponse(registeredUsers,invitedUsers,failures,ignored);
    }

    @Override
    public SpaceMemberResponse findBySpaceIdAndPersonId(Long spaceId, Long personId) {
        Optional<SpaceMembers> optionalSpaceMembers = spaceMemberRepository.findBySpaceIdAndPersonId(spaceId, personId);
        if (optionalSpaceMembers.isPresent()){
            SpaceMembers spaceMember = optionalSpaceMembers.get();
            SpaceMemberResponse spaceMemberResponse =  getSpaceMemberResponseFromSpaceMember(spaceMember);
            return spaceMemberResponse;
        }else{
            throw new ResourceNotFoundException("Details with particular data not found, spaceId : " + spaceId + " personId : " + personId);
        }


    }

    @Override
    public SpaceMemberResponse findByParticularId(Long spaceMemberId) {
        Optional<SpaceMembers> optionalSpaceMember = spaceMemberRepository.findById(spaceMemberId);
        if (optionalSpaceMember.isPresent()){
            SpaceMembers spaceMember = optionalSpaceMember.get();
            SpaceMemberResponse spaceMemberResponse =  getSpaceMemberResponseFromSpaceMember(spaceMember);
            return spaceMemberResponse;
        }else{
            throw new ResourceNotFoundException("Details not found, id : " + spaceMemberId);
        }
    }
}


