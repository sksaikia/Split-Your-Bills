package com.example.splityourbills.repository;

import com.example.splityourbills.entity.Invite;
import com.example.splityourbills.entity.SpaceMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {
    Optional<Invite> findByPhoneNo(String phoneNo);
    Optional<Invite> findByInviteId(Long id);
    Optional<Invite> findBySpaceIdAndPhoneNo(Long spaceId,String phoneNo);
}
