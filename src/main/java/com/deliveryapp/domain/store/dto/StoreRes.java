package com.deliveryapp.domain.store.dto;

import com.deliveryapp.domain.menu.domain.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class StoreRes {
    private String storeName;
    private Integer rating;
    private String minPrice;
    private Integer deliveryTip;

    private List<MenuRes> menuList;

    public StoreRes(String storeName, Integer rating, String minPrice, Integer deliveryTip, List<MenuRes> menuList) {
        this.storeName = storeName;
        this.rating = rating;
        this.minPrice = minPrice;
        this.deliveryTip = deliveryTip;
        this.menuList = menuList;
    }
}
