package com.deliveryapp.domain.coupon.domain;

import com.deliveryapp.domain.common.BaseEntity;
import com.deliveryapp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "couponStatus")
    private String couponStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_info_id")
    private CouponInfo couponInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public Coupon(String couponStatus, CouponInfo couponInfo, User user) {
        this.couponStatus = couponStatus;
        this.couponInfo = couponInfo;
        this.user = user;
    }
}
