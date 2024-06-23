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
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="order_id")
    private String orderId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "cart_id")
    private String cartId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
