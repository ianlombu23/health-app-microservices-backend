package com.woyo.ms_order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddCartResponse {
    private String cartId;
    private String userId;
}
