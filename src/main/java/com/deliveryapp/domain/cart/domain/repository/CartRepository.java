package com.deliveryapp.domain.cart.domain.repository;

import com.deliveryapp.domain.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
