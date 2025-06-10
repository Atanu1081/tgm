package com.marketplace.orders.controller;

import com.marketplace.orders.dto.AccountsContactInfoDto;
import com.marketplace.orders.dto.OrderDto;
import com.marketplace.orders.entity.Orders;
import com.marketplace.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @GetMapping(path = "/list")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> allOrders = orderService.getAllOrders();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allOrders);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Orders> addOrder(@RequestBody OrderDto orderDto) {
        Orders order = orderService.addOrder(orderDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(order);
    }

    @DeleteMapping(path = "/remove")
    public ResponseEntity<String> deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Order deleted with id : " + orderId);
    }

    @GetMapping(path = "/app-version")
    public String getBuildVersion() {
        return buildVersion;
    }

    @GetMapping(path = "/java-version")
    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    @GetMapping(path = "/account-info")
    public AccountsContactInfoDto getAccountInfo() {
        return accountsContactInfoDto;
    }
}
