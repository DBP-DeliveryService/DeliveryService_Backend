package com.deliveryapp.domain.coupon.domain.repository;

import com.deliveryapp.domain.coupon.domain.CouponInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponInfoRepository extends JpaRepository<CouponInfo, Long> {

    @Query(value = "SELECT c FROM CouponInfo c WHERE c.couponCode = :couponCode")
    CouponInfo findByCouponCode(String couponCode);
}
