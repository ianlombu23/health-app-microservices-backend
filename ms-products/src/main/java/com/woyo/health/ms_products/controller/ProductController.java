package com.woyo.health.ms_products.controller;

import com.woyo.health.ms_products.request.CreateProductRequest;
import com.woyo.health.ms_products.response.CreateProductResponse;
import com.woyo.health.ms_products.response.ProductDetailResponse;
import com.woyo.health.ms_products.service.CreateProductService;
import com.woyo.health.ms_products.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/v1/")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductService createProductService;
    private final ProductDetailService productDetailService;

    @PostMapping("/create")
    public CreateProductResponse createProductCategoryResponse(@RequestBody CreateProductRequest createProductRequest) {
        return createProductService.createProduct(createProductRequest);
    }

    @GetMapping("/detail/{productId}")
    public ProductDetailResponse getProductDetail(@PathVariable String productId) {
        return productDetailService.getProductDetailResponse(productId);
    }
}
