package com.deliveryapp.domain.coupon.domain.repository;

import com.deliveryapp.domain.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}