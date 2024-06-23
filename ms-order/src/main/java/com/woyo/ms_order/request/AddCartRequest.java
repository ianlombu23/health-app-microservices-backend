package com.woyo.ms_order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddCartRequest {
    private String userId;
    private String cartId;
    private String productId;
    private Integer quantity;
}
