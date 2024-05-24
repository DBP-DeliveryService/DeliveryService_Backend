package com.deliveryapp.domain.store.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class MenuRes {
    private String menuName;

    private String menuContent;

    private Long price;

    private String menuPictureUrl;

    public MenuRes(String menuName, String menuContent, Long price, String menuPictureUrl) {
        this.menuName = menuName;
        this.menuContent = menuContent;
        this.price = price;
        this.menuPictureUrl = menuPictureUrl;
    }
}
