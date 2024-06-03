package com.deliveryapp.domain.coupon.domain.repository;

import com.deliveryapp.domain.coupon.domain.Coupon;
import com.deliveryapp.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    @Query("SELECT c FROM Coupon c LEFT JOIN c.couponInfo ci WHERE c.user.id = :userId")
    List<Coupon> findByUserId(long userId);
}
