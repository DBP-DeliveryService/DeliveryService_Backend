package com.deliveryapp.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCategoryRes {
    private String storeName;
    private String detailOpreateStatus;
    private Integer rating;
    private Integer minPrice;
    private Integer minDeliveryTime;
    private Integer deliveryTip;
    private String detailCategoryName;

    public SearchCategoryRes(String storeName, String detailOpreateStatus, Integer rating, String minPrice, Integer minDeliveryTime, Integer deliveryTip, String detailCategoryName) {
        this.storeName = storeName;
        this.detailOpreateStatus = detailOpreateStatus;
        this.rating = rating;
        this.minPrice = Integer.parseInt(minPrice);
        this.minDeliveryTime = minDeliveryTime;
        this.deliveryTip = deliveryTip;
        this.detailCategoryName = detailCategoryName;
    }
}
