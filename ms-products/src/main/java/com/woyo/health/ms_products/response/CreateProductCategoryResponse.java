package com.woyo.health.ms_products.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateProductCategoryResponse {
    private String categoryId;
    private String categoryName;
}
