package com.woyo.health.ms_account.model.entity;

import com.woyo.health.ms_account.model.enums.Gender;
import jakarta.persistence.*;
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
@Table(name = "docter")
public class Docter extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name="docter_id")
    private String docterId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="specialist_id")
    private String specialistId;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "email")
    private String email;
}
