package com.deliveryapp.domain.order.domain;

import com.deliveryapp.domain.cart.domain.Cart;
import com.deliveryapp.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "totalPrice")
    private String totalPrice;

    @Column(name = "requestMsg")
    private String requestMsg;

    @Column(name = "orderStatus")
    private String orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @Builder
    public Order(String totalPrice, String requestMsg, String orderStatus) {
        this.totalPrice = totalPrice;
        this.requestMsg = requestMsg;
        this.orderStatus = orderStatus;
    }
}
