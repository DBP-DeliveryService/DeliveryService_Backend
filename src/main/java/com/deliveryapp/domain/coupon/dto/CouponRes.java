package com.deliveryapp.domain.coupon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CouponRes {
    private Long id;
    private String couponStatus;
    private String couponName;
    private Integer discountAmount;
    private String couponContent;
    private Integer minPrice;
    private Integer expiredDate;

    @Builder
    public CouponRes(Long id, String couponStatus, String couponName, Integer discountAmount, String couponContent, Integer minPrice, Integer expiredDate) {
        this.id = id;
        this.couponStatus = couponStatus;
        this.couponName = couponName;
        this.discountAmount = discountAmount;
        this.couponContent = couponContent;
        this.minPrice = minPrice;
        this.expiredDate = expiredDate;
    }
}
