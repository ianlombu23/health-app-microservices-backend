package com.woyo.health.ms_products.service;

import com.woyo.health.ms_products.model.entity.Product;
import com.woyo.health.ms_products.model.entity.ProductCategory;
import com.woyo.health.ms_products.repository.ProductCategoryRepository;
import com.woyo.health.ms_products.repository.ProductRepository;
import com.woyo.health.ms_products.request.CreateProductRequest;
import com.woyo.health.ms_products.response.CreateProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = Product.builder()
                .productName(request.getProductName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        Product newProduct = productRepository.save(product);

        request.getCategoryId().forEach(c -> productCategoryRepository.save(ProductCategory.builder()
                        .productId(newProduct.getProductId())
                        .categoryId(c)
                        .build()));

        return CreateProductResponse.builder()
                .productId(newProduct.getProductId())
                .productName(newProduct.getProductName())
                .description(newProduct.getDescription())
                .price(newProduct.getPrice())
                .categoryId(request.getCategoryId())
                .build();
    }
}
