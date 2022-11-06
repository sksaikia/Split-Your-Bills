package com.example.splityourbills.repository;

import com.example.splityourbills.entity.SpaceMembers;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpaceMemberRepository extends JpaRepository<SpaceMembers, Long> {
    Optional<List<SpaceMembers>> findAllBySpaceId(Long spaceId);
    Boolean existsBySpaceId(Long spaceId);
    Optional<SpaceMembers> findBySpaceIdAndPersonId(Long spaceId, Long personId);
    Optional<List<SpaceMembers>> findAllByInviteId(Long inviteId);
    Optional<List<SpaceMembers>> findAllByPersonId(Long userId, Sort sort);
}
/***
 * - Find All Members by space ID
 * - Check whether a spaceExist or not
 * - FInd One Member detail by space and person id
 * - FInd all space details by invite id
 * - Find all space details by user id
 */