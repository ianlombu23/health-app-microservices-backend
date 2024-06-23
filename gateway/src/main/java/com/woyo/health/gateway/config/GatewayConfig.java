package com.woyo.health.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(r -> r.path("/woyo/health/ms-order/**")
                        .filters(f -> f.rewritePath("/woyo/health/ms-order/(?<segment>.*)", "/${segment}"))
                        .uri("lb://MS-ORDER"))
                .route(r -> r.path("/woyo/health/ms-products/**")
                        .filters(f -> f.rewritePath("/woyo/health/ms-products/(?<segment>.*)", "/${segment}"))
                        .uri("lb://MS-PRODUCTS"))
                .route(r -> r.path("/woyo/health/ms-account/**")
                        .filters(f -> f.rewritePath("/woyo/health/ms-account/(?<segment>.*)", "/${segment}"))
                        .uri("lb://MS-ACCOUNT"))
                .build();

    }
}
