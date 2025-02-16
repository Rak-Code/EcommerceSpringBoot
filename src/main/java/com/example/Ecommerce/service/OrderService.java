// src/main/java/com/example/Ecommerce/service/OrderService.java
package com.example.Ecommerce.service;

import com.example.Ecommerce.entity.*;
import com.example.Ecommerce.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private  OrderDetailsRepository orderDetailsRepository;

    public Order createOrder(Long userId, List<OrderItemRequest> items) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setStatus("PENDING");
        order.setTotalAmount(0.0);

        Order savedOrder = orderRepository.save(order);

        double total = 0.0;
        for (OrderItemRequest item : items) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(savedOrder);
            orderDetails.setProduct(product);
            orderDetails.setQuantity(item.getQuantity());
            orderDetails.setPriceAtPurchase(product.getPrice());

            total += product.getPrice() * item.getQuantity();
            orderDetailsRepository.save(orderDetails);
        }

        savedOrder.setTotalAmount(total);
        savedOrder.setStatus("COMPLETED");
        return orderRepository.save(savedOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // DTO with proper getters/setters
    public static class OrderItemRequest {
        private Long productId;
        private Integer quantity;

        // Getters and setters
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}