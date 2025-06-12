package com.marketplace.product.service;

import com.marketplace.product.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "order")
public interface OrderFeignClient {

    @GetMapping(path = "/api/v1/orders/list")
    public ResponseEntity<List<OrderDto>> getAllOrders();
}
