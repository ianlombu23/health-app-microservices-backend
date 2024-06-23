package com.woyo.health.ms_products.response;

import com.woyo.health.ms_products.DTO.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProductDetailResponse {
    private String productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private List<CategoryDTO> categoryList;
}
