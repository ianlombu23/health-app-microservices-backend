package com.woyo.ms_order.controller;

import com.woyo.ms_order.request.AddCartRequest;
import com.woyo.ms_order.response.AddCartResponse;
import com.woyo.ms_order.service.AddCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final AddCartService addCartService;

    @PostMapping("/add")
    public AddCartResponse addCart(@RequestBody AddCartRequest addCartRequest) {
        return addCartService.addCart(addCartRequest);
    }
}
