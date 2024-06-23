package com.woyo.ms_order.service;

import com.woyo.ms_order.entity.Cart;
import com.woyo.ms_order.entity.OrderProduct;
import com.woyo.ms_order.exception.CustomException;
import com.woyo.ms_order.feign.product.ProductDetailResponse;
import com.woyo.ms_order.feign.product.ProductFeignImpl;
import com.woyo.ms_order.repository.CartRepository;
import com.woyo.ms_order.repository.OrderProdutRepository;
import com.woyo.ms_order.request.AddCartRequest;
import com.woyo.ms_order.response.AddCartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddCartService {
    private final CartRepository cartRepository;
    private final OrderProdutRepository orderProductRepository;
    private final ProductFeignImpl productFeign;

    public AddCartResponse addCart(AddCartRequest request) {
        Cart newCart = getOrCreateCard(request);
        saveOrderProduct(newCart, request);
        return AddCartResponse.builder()
                .cartId(newCart.getCartId())
                .userId(request.getUserId())
                .build();
    }

    private Cart getOrCreateCard(AddCartRequest request) {
        return Optional.ofNullable(request.getCartId())
                .map(c -> cartRepository.findById(request.getCartId())
                        .orElseThrow(() -> new CustomException(
                                "2500",
                                "Cart tidak ditemukan",
                                HttpStatus.CONFLICT
                        ))
                ).orElseGet(() -> createNewCart(request));
    }

    private Cart createNewCart(AddCartRequest request) {
        return cartRepository.save(Cart.builder()
                .userId(request.getUserId())
                .build());
    }

    private void saveOrderProduct(Cart cart, AddCartRequest request) {
        ProductDetailResponse product = productFeign.getProductDetail(request.getProductId());
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
        Optional<OrderProduct> existingOrderProduct = orderProductRepository.findByProductIdAndCartIdAndUserId(request.getProductId(), cart.getCartId(), request.getUserId());
        OrderProduct orderProduct = existingOrderProduct.map(o -> {
            o.setQuantity(request.getQuantity());
            o.setPrice(product.getPrice());
            o.setTotalProductPrice(totalPrice);
            return o;
        }).orElseGet(() -> OrderProduct.builder()
                .productId(request.getProductId())
                .cartId(cart.getCartId())
                .userId(request.getUserId())
                .quantity(request.getQuantity())
                .price(product.getPrice())
                .totalProductPrice(totalPrice)
                .build());

        orderProductRepository.save(orderProduct);
    }
}
