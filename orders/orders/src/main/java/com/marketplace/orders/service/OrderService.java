package com.marketplace.orders.service;

import com.marketplace.orders.dto.OrderDto;
import com.marketplace.orders.entity.Orders;
import com.marketplace.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> getAllOrders() {
        List<Orders> ordersList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (int i = 0; i < ordersList.size(); i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(ordersList.get(i).getOrderId());
            orderDto.setAmount(ordersList.get(i).getAmount());
            orderDto.setOrderStatus(ordersList.get(i).getOrderStatus());
            orderDto.setOrderDate(ordersList.get(i).getOrderDate());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    public Orders addOrder(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setOrderId(orderDto.getOrderId());
        orders.setAmount(orderDto.getAmount());
        orders.setOrderStatus(orderDto.getOrderStatus());
        orders.setOrderDate(orderDto.getOrderDate());
        return orderRepository.save(orders);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
