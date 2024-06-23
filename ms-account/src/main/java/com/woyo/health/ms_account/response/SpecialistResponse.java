package com.woyo.health.ms_account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SpecialistResponse {
    private String specialistId;
    private String specialistName;
}
