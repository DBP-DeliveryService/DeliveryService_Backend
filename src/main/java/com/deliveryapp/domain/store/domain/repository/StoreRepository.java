package com.deliveryapp.domain.store.domain.repository;

import com.deliveryapp.domain.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT s FROM Store s JOIN Delivery d ON s.id = d.store.id WHERE s.detailCategory.id = :categoryId")
    List<Store> findAllByCategoryId(Long categoryId);

    Optional<Store> findByStoreName(String storeName);
}
