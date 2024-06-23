package com.woyo.health.ms_account.controller;

import com.woyo.health.ms_account.request.DocterListRequest;
import com.woyo.health.ms_account.request.DocterRegisterRequest;
import com.woyo.health.ms_account.response.DocterDetailResponse;
import com.woyo.health.ms_account.response.DocterListResponse;
import com.woyo.health.ms_account.response.DocterRegisterResponse;
import com.woyo.health.ms_account.service.DocterDetailService;
import com.woyo.health.ms_account.service.DocterListService;
import com.woyo.health.ms_account.service.DocterRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1/docter")
@RequiredArgsConstructor
public class DocterController {

    private final DocterRegisterService docterRegisterService;
    private final DocterDetailService docterDetailService;
    private final DocterListService docterListService;

    @PostMapping("/register")
    public DocterRegisterResponse docterRegister(@RequestBody DocterRegisterRequest docterRegisterRequest) {
        return docterRegisterService.register(docterRegisterRequest);
    }

    @GetMapping("/detail/{docterId}")
    public DocterDetailResponse getDocterDetail(@PathVariable String docterId) {
        return docterDetailService.getDocterDetail(docterId);
    }

    @GetMapping("/list")
    public DocterListResponse getDocterListResponse(@RequestParam(name = "specialistId", required = false) String specialistId,
                                                    @RequestParam(name = "gender", required = false) String gender) {
        return docterListService.getDocterList(DocterListRequest.builder()
                .specialistId(specialistId)
                .gender(gender)
                .build());
    }

}
