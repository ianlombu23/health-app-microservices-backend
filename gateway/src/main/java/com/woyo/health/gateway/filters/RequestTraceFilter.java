package com.woyo.health.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (isTokenPresent(requestHeaders)) {
            logger.debug("token found in RequestTraceFilter : {}",
                    filterUtility.getBearerToken(requestHeaders));
        } else {
            String correlationID = generateToken();
            exchange = filterUtility.setCorrelationId(exchange, correlationID);
            logger.debug("token generated in RequestTraceFilter : {}", correlationID);
        }
        return chain.filter(exchange);
    }

    private boolean isTokenPresent(HttpHeaders requestHeaders) {
        return filterUtility.getBearerToken(requestHeaders) != null;
    }

    private String generateToken() {
        return java.util.UUID.randomUUID().toString();
    }

}
