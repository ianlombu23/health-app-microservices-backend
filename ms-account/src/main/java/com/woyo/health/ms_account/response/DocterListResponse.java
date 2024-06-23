package com.woyo.health.ms_account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DocterListResponse {
    private List<DocterDetailResponse> docterList;
}
