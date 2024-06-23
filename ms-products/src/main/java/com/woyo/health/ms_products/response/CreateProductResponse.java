package com.woyo.health.ms_products.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CreateProductResponse {
    private String productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private List<String> categoryId;
}
