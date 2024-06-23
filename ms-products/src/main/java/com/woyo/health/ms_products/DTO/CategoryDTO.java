package com.woyo.health.ms_products.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CategoryDTO {
    private String categoryId;
    private String categoryName;
}
