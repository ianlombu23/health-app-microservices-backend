package com.woyo.health.ms_account.service;

import com.woyo.health.ms_account.exception.CustomException;
import com.woyo.health.ms_account.model.entity.Specialist;
import com.woyo.health.ms_account.request.CreateSpecialistRequest;
import com.woyo.health.ms_account.response.SpecialistResponse;
import com.woyo.health.ms_account.repository.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialistService {

    private final SpecialistRepository specialistRepository;

    public SpecialistResponse create(CreateSpecialistRequest request) {
        specialistRepository.findBySpecialistName(request.getSpecialistName())
                .ifPresent(r -> {
                    throw new CustomException("1115", "Specialist Name telah tersedia", HttpStatus.CONFLICT);
                });

        Specialist newSpecialist = specialistRepository.save(Specialist.builder()
                .specialistName(request.getSpecialistName())
                .build());

        return SpecialistResponse.builder()
                .specialistId(newSpecialist.getSpecialistId())
                .specialistName(newSpecialist.getSpecialistName())
                .build();

    }
}
