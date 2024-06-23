package com.woyo.health.ms_products.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CreateProductRequest {
    private String productName;
    private String description;
    private BigDecimal price;
    private List<String> categoryId;
}
