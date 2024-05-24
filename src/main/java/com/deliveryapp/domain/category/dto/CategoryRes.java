package com.deliveryapp.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class CategoryRes {
    private Long id;
    private String categoryName;
    private String categoryImgUrl;


    public CategoryRes(Long id, String categoryName, String categoryImgUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryImgUrl = categoryImgUrl;
    }
}
