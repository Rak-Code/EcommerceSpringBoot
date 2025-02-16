// src/main/java/com/example/Ecommerce/repository/CategoryRepository.java
package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Optional: Find category by name
    Category findByName(String name);
}