package com.deliveryapp.domain.store.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Delivery")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "min_delivery_time")
    private Integer minDeliveryTime;

    @Column(name = "max_delivery_time")
    private Integer maxDeliveryTime;

    @Column(name = "delivery_tip")
    private Integer deliveryTip;

    @Column(name = "delivery_area")
    private String deliveryArea;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Delivery(Integer minDeliveryTime, Integer maxDeliveryTime, Integer deliveryTip, String deliveryArea) {
        this.minDeliveryTime = minDeliveryTime;
        this.maxDeliveryTime = maxDeliveryTime;
        this.deliveryTip = deliveryTip;
        this.deliveryArea = deliveryArea;
    }
}
