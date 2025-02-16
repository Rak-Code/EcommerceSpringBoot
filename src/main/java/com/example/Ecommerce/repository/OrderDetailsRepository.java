// src/main/java/com/example/Ecommerce/repository/OrderDetailsRepository.java
package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}