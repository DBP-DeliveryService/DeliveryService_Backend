package com.deliveryapp.domain.category.domain.repository;

import com.deliveryapp.domain.category.domain.DetailCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailCategoryRepository extends JpaRepository<DetailCategory, Long> {
    List<DetailCategory> findByIdBetween(Long startId, Long endId);
}
