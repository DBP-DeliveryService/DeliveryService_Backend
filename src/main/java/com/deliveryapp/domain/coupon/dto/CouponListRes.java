package com.deliveryapp.domain.coupon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class CouponListRes {
    private List<CouponRes> couponResList;


    @Builder
    public CouponListRes(List<CouponRes> couponResList) {
        this.couponResList = couponResList;
    }
}

