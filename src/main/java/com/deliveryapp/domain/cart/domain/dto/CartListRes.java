package com.deliveryapp.domain.cart.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class CartListRes {
    private Long id;
    private String menuName;
    private Integer quantity;
    private String menuContent;
    private Long price;

    public CartListRes(Long id, String menuName, Integer quantity, String menuContent, Long price) {
        this.id = id;
        this.menuName = menuName;
        this.quantity = quantity;
        this.menuContent = menuContent;
        this.price = price;
    }
}
