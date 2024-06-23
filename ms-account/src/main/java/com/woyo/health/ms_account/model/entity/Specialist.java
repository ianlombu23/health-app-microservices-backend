package com.woyo.health.ms_account.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialist")
public class Specialist extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="specialist_id")
    private String specialistId;

    @Column(name = "specialist_name")
    private String specialistName;
}
