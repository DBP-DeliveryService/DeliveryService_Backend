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



    public CategoryRes(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
