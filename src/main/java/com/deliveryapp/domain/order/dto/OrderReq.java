package com.deliveryapp.domain.order.dto;

import com.deliveryapp.domain.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrderReq {
    private String totalPrice;
    private String requestMsg;
    private String orderStatus;
    private String payment_method;
    private Long coupon_id;
    private List<Long> cartIdList;

}
