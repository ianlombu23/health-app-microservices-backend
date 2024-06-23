package com.woyo.health.ms_account.service;

import com.woyo.health.ms_account.model.enums.Gender;
import com.woyo.health.ms_account.model.projections.DocterDetailProjection;
import com.woyo.health.ms_account.request.DocterListRequest;
import com.woyo.health.ms_account.response.DocterDetailResponse;
import com.woyo.health.ms_account.response.DocterListResponse;
import com.woyo.health.ms_account.repository.DocterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocterListService {

    private final DocterRepository docterRepository;

    public DocterListResponse getDocterList(DocterListRequest request) {
        Gender gender = Optional.ofNullable(request.getGender()).map(Gender::valueOf).orElse(null);
        List<DocterDetailProjection> docterList = docterRepository.findAllDocterByFilter(request.getSpecialistId(), gender);

        List<DocterDetailResponse> response  = docterList.stream().map(this::enrichResponse).toList();
        return DocterListResponse.builder()
                 .docterList(response)
                 .build();
    }

    public DocterDetailResponse enrichResponse(DocterDetailProjection item) {
        return DocterDetailResponse.builder()
                .docterId(item.getDocterId())
                .fullName(item.getFullName())
                .specialistName(item.getSpecialistName())
                .gender(item.getGender())
                .email(item.getEmail())
                .isActive(item.getIsActive())
                .build();
    }
}
