package com.woyo.health.ms_account.repository;

import com.woyo.health.ms_account.model.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, String> {
    Optional<Specialist> findBySpecialistName(String specialistName);
}
