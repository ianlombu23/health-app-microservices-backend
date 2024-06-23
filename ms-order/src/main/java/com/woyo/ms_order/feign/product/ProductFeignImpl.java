package com.woyo.ms_order.feign.product;

import com.woyo.ms_order.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFeignImpl {
    private final ProductFeign productFeign;

    public ProductDetailResponse getProductDetail(String productId) {
        try {
            return productFeign.getProductDetail(productId).getBody();
        } catch (Exception e) {
            throw new CustomException("5000", "Server bermasalah", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
