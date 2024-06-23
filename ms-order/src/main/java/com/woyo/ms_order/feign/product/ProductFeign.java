package com.woyo.ms_order.feign.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ms-products")
public interface ProductFeign {
    @GetMapping("/product/v1/detail/{productId}")
    ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable String productId);
}
