package com.woyo.health.ms_products.controller;

import com.woyo.health.ms_products.request.CreateProductCategoryRequest;
import com.woyo.health.ms_products.response.CreateProductCategoryResponse;
import com.woyo.health.ms_products.service.CreateProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CreateProductCategoryService createProductCategoryService;

    @PostMapping("/create")
    public CreateProductCategoryResponse createProductCategoryResponse(@RequestBody CreateProductCategoryRequest createProductCategoryRequest) {
        return createProductCategoryService.createProductCategoryResponse(createProductCategoryRequest);
    }
}
