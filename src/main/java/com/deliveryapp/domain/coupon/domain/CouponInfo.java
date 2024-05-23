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

    @Column(name = "couponName")
    private Integer couponName;

    @Column(name = "couponContent")
    private Integer couponContent;

    @Column(name = "discountAmount")
    private Integer discountAmount;

    @Column(name = "expiredDate")
    private Integer expiredDate;

    @Column(name = "minPrice")
    private Integer minPrice;
}
