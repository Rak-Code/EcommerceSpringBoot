// src/main/java/com/example/Ecommerce/controller/OrderController.java
package com.example.Ecommerce.controller;

import com.example.Ecommerce.entity.Order;
import com.example.Ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Order> createOrder(
            @PathVariable Long userId,
            @RequestBody List<OrderService.OrderItemRequest> items
    ) {
        return new ResponseEntity<>(orderService.createOrder(userId, items), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}