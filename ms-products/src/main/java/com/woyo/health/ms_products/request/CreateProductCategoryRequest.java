package com.woyo.health.ms_products.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateProductCategoryRequest {
    private String categoryName;
}
