package com.woyo.health.ms_products.service;

import com.woyo.health.ms_products.model.entity.Category;
import com.woyo.health.ms_products.repository.CategoryRepository;
import com.woyo.health.ms_products.request.CreateProductCategoryRequest;
import com.woyo.health.ms_products.response.CreateProductCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCategoryService {
    private final CategoryRepository categoryRepository;

    public CreateProductCategoryResponse createProductCategoryResponse(CreateProductCategoryRequest request) {
        Category newCategory = categoryRepository.save(Category.builder()
                .categoryName(request.getCategoryName())
                .build());

        return CreateProductCategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .categoryName(newCategory.getCategoryName())
                .build();
    }
}
