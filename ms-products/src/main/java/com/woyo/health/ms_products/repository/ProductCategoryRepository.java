package com.woyo.health.ms_products.repository;

import com.woyo.health.ms_products.model.entity.ProductCategory;
import com.woyo.health.ms_products.model.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

    @Query(value = "SELECT c.categoryId AS categoryId, c.categoryName AS categoryName " +
            "FROM ProductCategory pc " +
            "JOIN Category c ON pc.categoryId = c.categoryId " +
            "WHERE pc.productId = :productId ")
    List<CategoryProjection> findAllByProductCategory(String productId);
}
