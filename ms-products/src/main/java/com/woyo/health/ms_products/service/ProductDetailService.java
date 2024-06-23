package com.woyo.health.ms_products.service;

import com.woyo.health.ms_products.DTO.CategoryDTO;
import com.woyo.health.ms_products.exception.CustomException;
import com.woyo.health.ms_products.model.entity.Product;
import com.woyo.health.ms_products.repository.ProductCategoryRepository;
import com.woyo.health.ms_products.repository.ProductRepository;
import com.woyo.health.ms_products.response.ProductDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductDetailResponse getProductDetailResponse(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException(
                        "1500",
                        "Product tidak ditemukan",
                        HttpStatus.INTERNAL_SERVER_ERROR
        ));

        List<CategoryDTO> categoryDTOList = productCategoryRepository.findAllByProductCategory(productId).stream()
                .map(p -> CategoryDTO.builder()
                        .categoryId(p.getCategoryId())
                        .categoryName(p.getCategoryName())
                        .build()
                ).toList();

        return ProductDetailResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryList(categoryDTOList)
                .build();
    }
}
