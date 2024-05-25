package com.deliveryapp.domain.coupon.domain;

import com.deliveryapp.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Coupon_Info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CouponInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "coupon_content")
    private String couponContent;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "expired_date")
    private Integer expiredDate;

    @Column(name = "min_price")
    private Integer minPrice;

    @Column(name = "coupon_code")
    private String couponCode;
}
