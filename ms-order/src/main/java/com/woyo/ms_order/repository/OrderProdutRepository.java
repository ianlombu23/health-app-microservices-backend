package com.woyo.ms_order.repository;

import com.woyo.ms_order.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderProdutRepository extends JpaRepository<OrderProduct, String> {
    Optional<OrderProduct> findByProductIdAndCartIdAndUserId(String productId, String cartId, String userId);
}
