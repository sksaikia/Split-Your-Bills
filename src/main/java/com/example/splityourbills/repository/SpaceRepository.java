package com.example.splityourbills.repository;

import com.example.splityourbills.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
    Optional<List<Space>> findAllByPersonId(Long PersonId);
}