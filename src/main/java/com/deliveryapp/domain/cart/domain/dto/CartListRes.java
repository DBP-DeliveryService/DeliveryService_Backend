package com.deliveryapp.domain.cart.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class CartListRes {
    private String menuName;
    private Integer quantity;
    private String menuContent;
    private Long price;

    public CartListRes(String menuName, Integer quantity, String menuContent, Long price) {
        this.menuName = menuName;
        this.quantity = quantity;
        this.menuContent = menuContent;
        this.price = price;
    }
}
