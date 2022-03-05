package com.example.splityourbills.controller;

import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import com.example.splityourbills.response.space.GetAllSpaceResponse;
import com.example.splityourbills.response.space.SpaceResponse;
import com.example.splityourbills.security.CurrentUser;
import com.example.splityourbills.security.UserPrincipal;
import com.example.splityourbills.service.implementation.SpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {
    @Autowired
    private SpaceServiceImpl spaceService;

    @Autowired
    private UserController userController;

    @PostMapping("/add")
    public BaseApiResponse addASpace(@RequestBody SpaceDTO spaceDTO, @CurrentUser UserPrincipal currentUser){
        long userId = userController.getCurrentUserId(currentUser);
        SpaceResponse spaceResponse =  spaceService.createNewSpace(spaceDTO,userId);
        if(spaceResponse!=null){
            return createBaseApiResponse(spaceResponse);
        }else{
            throw new InternalServerException("Issues with server");
        }

    }

    @GetMapping("/{spaceId}")
    public  BaseApiResponse getSpaceById(@PathVariable("spaceId") long spaceId){
        SpaceResponse spaceResponse = spaceService.getSpaceById(spaceId);
        if (spaceResponse!=null){
            return createBaseApiResponse(spaceResponse);
        }else{
            throw new ResourceNotFoundException("Space for that particular spaceId not found; spaceId : " + spaceId);
        }
    }

    @PutMapping("/{spaceId}")
    public BaseApiResponse editSpaceById(@RequestBody SpaceDTO spaceDTO,
                                         @CurrentUser UserPrincipal currentUser,
                                         @PathVariable("spaceId") long spaceId ){
        long userId = userController.getCurrentUserId(currentUser);
        SpaceResponse spaceResponse = spaceService.editSpace(spaceDTO,spaceId,userId);
        if (spaceResponse!=null){
            return createBaseApiResponse(spaceResponse);
        }else{
            throw new InternalServerException("Problems editing the space");
        }
    }

    private BaseApiResponse createBaseApiResponse(SpaceResponse spaceResponse){
        BaseApiResponse baseApiResponse = new BaseApiResponse(true);
        baseApiResponse.setData(spaceResponse);
        return baseApiResponse;
    }

}
