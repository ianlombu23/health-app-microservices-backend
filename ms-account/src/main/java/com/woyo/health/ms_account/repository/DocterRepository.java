package com.woyo.health.ms_account.repository;

import com.woyo.health.ms_account.model.entity.Docter;
import com.woyo.health.ms_account.model.enums.Gender;
import com.woyo.health.ms_account.model.projections.DocterDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocterRepository extends JpaRepository<Docter, String> {

    Optional<Docter> findByEmail(String email);

    @Query(value = "SELECT d.docterId AS docterId," +
            "d.fullName AS fullName, " +
            "d.gender AS gender, " +
            "d.email AS email, " +
            "d.isActive AS isActive, " +
            "s.specialistName AS specialistName " +
            "FROM Docter d " +
            "JOIN Specialist s ON d.specialistId = s.specialistId " +
            "WHERE d.docterId = :docterId")
    Optional<DocterDetailProjection> findDocterDetail(String docterId);

    @Query(value = "SELECT d.docterId AS docterId," +
            "d.fullName AS fullName, " +
            "d.gender AS gender, " +
            "d.email AS email, " +
            "d.isActive AS isActive, " +
            "s.specialistName AS specialistName " +
            "FROM Docter d " +
            "JOIN Specialist s ON d.specialistId = s.specialistId " +
            "WHERE (:specialistId IS NULL OR d.specialistId = :specialistId) " +
            "AND (:gender IS NULL OR d.gender = :gender) " +
            "AND d.isActive = true")
    List<DocterDetailProjection> findAllDocterByFilter(String specialistId, Gender gender);
}
