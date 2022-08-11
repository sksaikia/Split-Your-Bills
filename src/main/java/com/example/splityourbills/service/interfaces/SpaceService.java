package com.example.splityourbills.service.interfaces;

import com.example.splityourbills.dto.space.SpaceDTO;
import com.example.splityourbills.response.space.GetAllSpaceResponse;
import com.example.splityourbills.response.space.SpaceResponse;

import java.util.List;

public interface SpaceService {
    SpaceResponse createNewSpace(SpaceDTO spaceModel,Long userId);
    SpaceResponse getSpaceById(Long spaceId);
    SpaceResponse editSpace(SpaceDTO space,long spaceId,long userId);
    Boolean deleteSpace(Long spaceId);
}
