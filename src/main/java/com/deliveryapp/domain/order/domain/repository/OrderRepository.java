package com.deliveryapp.domain.order.domain.repository;

import com.deliveryapp.domain.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
