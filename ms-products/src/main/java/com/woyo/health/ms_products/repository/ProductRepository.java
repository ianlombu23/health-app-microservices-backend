package com.woyo.health.ms_products.repository;

import com.woyo.health.ms_products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

//    @Query(value = "SELECT * FROM Product p " +
//            "JOIN ProductCategory pc ON p.productId = pc.productId " +
//            "JOIN Category c ON pc.categoryId = c.categoryId " +
//            "WHERE p.product_id = :transaction "
//    )
//    Optional<ProductDetailProjection> findProductDetailByTransactionId(String transactionId);
}
