package com.woyo.health.ms_account.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
}
