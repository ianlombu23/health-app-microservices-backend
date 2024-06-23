package com.woyo.health.ms_account.controller;

import com.woyo.health.ms_account.request.CreateSpecialistRequest;
import com.woyo.health.ms_account.response.SpecialistResponse;
import com.woyo.health.ms_account.service.SpecialistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/v1/specialist")
@RequiredArgsConstructor
public class SpecialistController {

    private final SpecialistService specialistService;

    @PostMapping("/create")
    public SpecialistResponse create(@RequestBody CreateSpecialistRequest createSpecialistRequest) {
        return specialistService.create(createSpecialistRequest);
    }

}
