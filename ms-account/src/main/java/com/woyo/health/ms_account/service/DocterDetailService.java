package com.woyo.health.ms_account.service;

import com.woyo.health.ms_account.exception.CustomException;
import com.woyo.health.ms_account.model.projections.DocterDetailProjection;
import com.woyo.health.ms_account.response.DocterDetailResponse;
import com.woyo.health.ms_account.repository.DocterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocterDetailService {

    private final DocterRepository docterRepository;

    public DocterDetailResponse getDocterDetail(String docterId) {

        DocterDetailProjection docterDetail = docterRepository.findDocterDetail(docterId)
                .orElseThrow(() -> new CustomException(
                        "1300",
                        "Data tidak ditemukan",
                        HttpStatus.CONFLICT)
                );

        return DocterDetailResponse.builder()
                .docterId(docterDetail.getDocterId())
                .fullName(docterDetail.getFullName())
                .specialistName(docterDetail.getSpecialistName())
                .gender(docterDetail.getGender())
                .email(docterDetail.getEmail())
                .isActive(docterDetail.getIsActive())
                .build();
    }
}
