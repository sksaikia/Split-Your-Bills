package com.example.splityourbills.service.implementation;

import com.example.splityourbills.dto.spacemember.SpaceMembersDTO;
import com.example.splityourbills.entity.Space;
import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.repository.SpaceMemberRepository;
import com.example.splityourbills.repository.SpaceRepository;
import com.example.splityourbills.repository.UserRepository;
import com.example.splityourbills.response.space.GetAllSpaceResponse;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.service.interfaces.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpaceMemberServiceImpl spaceMemberService;

    //TODO add new entry in SpaceMembers
    @Override
    public SpaceResponse createNewSpace(SpaceDTO spaceDTO,Long userId) {
        Space space = getSpaceFromDTO(spaceDTO,userId);
        spaceRepository.save(space);
        long spaceId = space.getSpaceId();
        addUserToMembersList(new SpaceMembersDTO(spaceId,userId,0L,""));
        return createSpaceResponse(spaceId,space);
    }

    private void addUserToMembersList(SpaceMembersDTO spaceMembersDTO) {
        spaceMemberService.addSpaceCreatorToMemberList(spaceMembersDTO);
    }

//    //TODO move it to SpaceMembers
//    @Override
//    public GetAllSpaceResponse getAllSpacesByUserId(Long userId) {
//        System.out.println("USERID : " + userId);;
//        Optional<List<Space>> optionalSpaces = spaceRepository.findAllByPersonId(userId);
//        if (optionalSpaces.isPresent()){
//            List<Space> spaces = optionalSpaces.get();
//            List<SpaceResponse> spaceResponses = new ArrayList<>();
//            for (Space space : spaces){
//                SpaceResponse spaceResponse = getSpaceResponseFromSpace(space);
//                spaceResponses.add(spaceResponse);
//
//            }
//            GetAllSpaceResponse response = new GetAllSpaceResponse();
//            response.setTotalSpaces(spaces.size());
//            response.setSpaceResponse(spaceResponses);
//            return response;
//        }else{
//
//        }
//        return null;
//    }



    @Override
    public SpaceResponse getSpaceById(Long spaceId) {
        Optional<Space> optionalSpace = spaceRepository.findById(spaceId);
        if (optionalSpace.isPresent()){
            Space space = optionalSpace.get();
            SpaceResponse spaceResponse = getSpaceResponseFromSpace(space);
            return spaceResponse;
        }else{
            throw new ResourceNotFoundException("This current space is not available");
        }
    }


    //TODO test this
    public SpaceResponse editSpace(SpaceDTO space,long spaceId,long userId){
        Optional<Space> optionalSpace = spaceRepository.findById(spaceId);

        if (optionalSpace.isPresent()){

            Space currentSpace = optionalSpace.get();
            currentSpace.setSpaceName(space.getSpaceName());
            currentSpace.setSpaceDescription(space.getSpaceDescription());
            spaceRepository.save(currentSpace);
            long currentSpaceId = currentSpace.getSpaceId();

            return createSpaceResponse(currentSpaceId,currentSpace);
        }else{
            //TODO throw exception
            throw new ResourceNotFoundException("This current space is not available");
        }

    }

    private SpaceResponse createSpaceResponse(long currentSpaceId, Space currentSpace) {
        SpaceResponse spaceResponse = new SpaceResponse(currentSpaceId, currentSpace.getPersonId(), currentSpace.getSpaceName(),currentSpace.getSpaceDescription(),true,currentSpace.getLastUpdated());
        return spaceResponse;
    }


    private SpaceResponse getSpaceResponseFromSpace(Space space){
        SpaceResponse spaceResponse = new SpaceResponse(space.getSpaceId(),space.getPersonId(),
                space.getSpaceName(),space.getSpaceDescription(),space.getActive(),
                space.getLastUpdated());
        return spaceResponse;
    }


    private Space getSpaceFromDTO(SpaceDTO spaceDTO, Long userId) {
        Space space = new Space(spaceDTO,userId);
        return space;
    }


}


