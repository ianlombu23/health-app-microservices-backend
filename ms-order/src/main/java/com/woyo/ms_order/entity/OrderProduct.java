package com.woyo.ms_order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="order_product_id")
    private String orderProductId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "cart_id")
    private String cartId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "total_product_price")
    private BigDecimal totalProductPrice;

}
