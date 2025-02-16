// src/main/java/com/example/ecommerce/repository/UserRepository.java
package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query (optional)
    User findByEmail(String email);
}