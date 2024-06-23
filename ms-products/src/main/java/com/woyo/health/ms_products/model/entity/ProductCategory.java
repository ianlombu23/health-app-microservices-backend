package com.woyo.health.ms_products.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_category")
public class ProductCategory extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name="product_category_id")
    private String productCategoryId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "category_id")
    private String categoryId;
}
