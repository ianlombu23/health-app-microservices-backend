package com.woyo.health.ms_account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DocterDetailResponse {
    private String docterId;
    private String fullName;
    private String specialistName;
    private String gender;
    private String email;
    private Boolean isActive;
}
