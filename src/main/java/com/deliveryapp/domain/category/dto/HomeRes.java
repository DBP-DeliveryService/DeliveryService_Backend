package com.deliveryapp.domain.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class HomeRes {
    private List<CategoryRes> categoryResList;
    private List<CategoryRes> top5CategoryResList;

    public HomeRes(List<CategoryRes> categoryResList, List<CategoryRes> top5CategoryResList) {
        this.categoryResList = categoryResList;
        this.top5CategoryResList = top5CategoryResList;
    }
}
