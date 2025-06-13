package com.marketplace.gatewayserver.filters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Configuration
public class ResponseFilters {

	public static void main(String[] args) {
		SpringApplication.run(ResponseFilters.class, args);
	}

	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				exchange.getResponse().getHeaders().add("eazybank-correlation-id", java.util.UUID.randomUUID().toString());
			}));
		};
	}
}
