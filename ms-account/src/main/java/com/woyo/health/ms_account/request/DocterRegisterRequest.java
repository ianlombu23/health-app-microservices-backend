package com.woyo.health.ms_account.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DocterRegisterRequest {
    private String fullName;
    private String specialistId;
    private String gender;
    private boolean isActive;
    private String email;
}
