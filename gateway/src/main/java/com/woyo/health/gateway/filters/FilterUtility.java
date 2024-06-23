package com.woyo.health.gateway.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


@Component
public class FilterUtility {

    public String getBearerToken(HttpHeaders headers) {
        if (headers.get(HttpHeaders.AUTHORIZATION) != null) {
            return headers.get(HttpHeaders.AUTHORIZATION).stream().findFirst().get();
        } else {
            return null;
        }
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, HttpHeaders.AUTHORIZATION, correlationId);
    }
}
