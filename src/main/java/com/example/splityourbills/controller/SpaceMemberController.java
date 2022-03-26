package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.dto.auth.ApiResponse;
import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.dto.spacemember.NewSpaceMemberDTO;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.response.spaceMember.AddMemberToSpaceResponse;
import com.example.splityourbills.response.spaceMember.GetAllSpaceMembersResponse;
import com.example.splityourbills.response.spaceMember.SpaceMemberResponse;
import com.example.splityourbills.security.CurrentUser;
import com.example.splityourbills.security.UserPrincipal;
import com.example.splityourbills.service.implementation.SpaceMemberServiceImpl;
import com.example.splityourbills.service.implementation.SpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/spaces/member")
public class SpaceMemberController {

    @Autowired
    SpaceMemberServiceImpl spaceMemberService;

    @PostMapping("/add")
    public BaseApiResponse addOrInviteMemberIntoSpace(@RequestBody List<NewSpaceMemberDTO> spaceDTO){

        AddMemberToSpaceResponse addMemberToSpaceResponse =  spaceMemberService.addOrInviteMemberToSpace(spaceDTO);
        if (addMemberToSpaceResponse!=null){
            return createBaseApiResponse(addMemberToSpaceResponse);
        }else{
            throw new InternalServerException("Unexpected error occured");
        }
    }

    @GetMapping("/{spaceId}")
    public BaseApiResponse getAllMembersBySpaceId(@PathVariable("spaceId") Long spaceId){
        GetAllSpaceMembersResponse response = spaceMemberService.getAllMembersbySpaceId(spaceId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new ResourceNotFoundException("Space does not exist");
        }
    }
    @GetMapping()
    public BaseApiResponse getAllDetailsBySpaceAndPersonId(@RequestParam Long spaceId,
                                                           @RequestParam Long personId){
        SpaceMemberResponse spaceMemberResponse = spaceMemberService.findBySpaceIdAndPersonId(spaceId, personId);
        if (spaceMemberResponse!=null){
            return createBaseApiResponse(spaceMemberResponse);
        }else{
            throw new ResourceNotFoundException("Details does not exist");
        }
    }

    @GetMapping("/id")
    public BaseApiResponse getParticularMemberDetailById(@RequestParam Long spaceMemberId){
        SpaceMemberResponse spaceMemberResponse = spaceMemberService.findByParticularId(spaceMemberId);
        if (spaceMemberResponse!=null){
            return createBaseApiResponse(spaceMemberResponse);
        }else{
            throw new ResourceNotFoundException("Details does not exist");
        }
    }

    @GetMapping("/invite")
    public BaseApiResponse getAllSpaceMemberDetailsByInviteId(@RequestParam Long inviteId){
        GetAllSpaceMembersResponse response = spaceMemberService.getAllSpacesByInviteId(inviteId);
        if (response!=null){
            return createBaseApiResponse(response);
        }else{
            throw new ResourceNotFoundException("Space does not exist");
        }
    }

    @DeleteMapping("/delete")
    public BaseApiResponse deleteSpaceMemberDetailById(@RequestParam Long id){
        Boolean state = spaceMemberService.deleteById(id);
        if (true){
            return createBaseApiResponse(new ApiResponse(true,"Record deleted", HttpStatus.OK));
        }else{
            throw new ResourceNotFoundException("Space does not exist");
        }
    }


    private <DT> BaseApiResponse<DT> createBaseApiResponse(DT data){
        BaseApiResponse<DT> baseApiResponse = new BaseApiResponse<>(true);
        baseApiResponse.setData(data);
        return baseApiResponse;
    }

}
