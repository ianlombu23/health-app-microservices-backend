package com.woyo.ms_order.feign.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private String productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private List<CategoryDTO> categoryList;
}
