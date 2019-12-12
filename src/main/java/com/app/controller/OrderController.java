package com.app.controller;

import com.app.dto.OrderDto;
import com.app.model.Order;
import com.app.model.OrderIdentity;
import com.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public List<OrderDto> getAll() {
        return orderRepository
                .findAll()
                .stream()
                .map(Order::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{customerId}/{productId}")
    public OrderDto getOne(@PathVariable Long customerId, @PathVariable Long productId) {
        return orderRepository
                .findById(OrderIdentity.builder()
                        .customerId(customerId)
                        .productId(productId)
                        .build())
                .map(Order::toDto)
                .orElseThrow(() -> new IllegalStateException("cannot find order"));
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderDto> getByCustomer(@PathVariable Long customerId) {
        return orderRepository
                .findByOrderIdentityCustomerId(customerId)
                .stream()
                .map(Order::toDto)
                .collect(Collectors.toList());
    }
}
