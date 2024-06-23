package com.woyo.health.ms_account.service;

import com.woyo.health.ms_account.exception.CustomException;
import com.woyo.health.ms_account.model.entity.Docter;
import com.woyo.health.ms_account.model.enums.Gender;
import com.woyo.health.ms_account.request.DocterRegisterRequest;
import com.woyo.health.ms_account.response.DocterRegisterResponse;
import com.woyo.health.ms_account.repository.DocterRepository;
import com.woyo.health.ms_account.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocterRegisterService {
    private final DocterRepository docterRepository;
    private final Validator validator;

    public DocterRegisterResponse register(DocterRegisterRequest request) {
        validateByEmail(request);

        Docter docter = Docter.builder()
                .fullName(request.getFullName())
                .specialistId(request.getSpecialistId())
                .gender(Gender.valueOf(request.getGender().toUpperCase()))
                .email(request.getEmail())
                .isActive(false)
                .build();

        docterRepository.save(docter);

        return DocterRegisterResponse.builder()
                .docterId(docter.getDocterId())
                .fullName(docter.getFullName())
                .specialistId(docter.getSpecialistId())
                .gender(docter.getGender().name())
                .email(docter.getEmail())
                .isActive(docter.isActive())
                .build();
    }

    private void validateByEmail(DocterRegisterRequest request) {
        if (!validator.isValidEmail(request.getEmail())) {
            throw new CustomException("1001", "Format Email Tidak Valid", HttpStatus.CONFLICT);
        }

        docterRepository.findByEmail(request.getEmail())
                .ifPresent(d -> {
                    throw new CustomException("1100", "Email Telah Digunakan", HttpStatus.CONFLICT);
                });
    }
}
