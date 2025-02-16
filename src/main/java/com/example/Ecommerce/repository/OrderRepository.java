// src/main/java/com/example/Ecommerce/repository/OrderRepository.java
package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}