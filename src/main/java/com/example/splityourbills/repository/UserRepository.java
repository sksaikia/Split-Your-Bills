package com.example.splityourbills.repository;

import com.example.splityourbills.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserIdIn(List<Long> userIds);

    Boolean existsByUserName(String username);

    Boolean existsByPhoneNo(String phoneNo);

    Optional<User> findByPhoneNo(String phoneNo);

}