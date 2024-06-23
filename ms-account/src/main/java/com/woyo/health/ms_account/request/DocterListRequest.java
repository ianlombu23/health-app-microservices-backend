package com.woyo.health.ms_account.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DocterListRequest {
    private String specialistId;
    private String gender;
}
