package com.deliveryapp.domain.category.domain.repository;

import com.deliveryapp.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
