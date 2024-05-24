package com.deliveryapp.domain.category.application;

import com.deliveryapp.domain.category.domain.DetailCategory;
import com.deliveryapp.domain.category.domain.repository.DetailCategoryRepository;
import com.deliveryapp.domain.category.dto.CategoryRes;
import com.deliveryapp.domain.category.dto.HomeRes;
import com.deliveryapp.domain.category.dto.SearchCategoryRes;
import com.deliveryapp.domain.store.domain.Store;
import com.deliveryapp.domain.store.domain.repository.StoreRepository;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final StoreRepository storeRepository;
    private final DetailCategoryRepository detailCategoryRepository;

    @Transactional
    public ResponseCustom<List<SearchCategoryRes>> searchStoresByCategory(Long categoryId) {
        List<Store> storeList = storeRepository.findAllByCategoryId(categoryId);

        List<SearchCategoryRes> searchCategoryResList = storeList.stream().map(store ->{
            return SearchCategoryRes.builder()
                    .storeName(store.getStoreName())
                    .detailOpreateStatus(store.getDetailOperateStatus())
                    .rating(store.getRating())
                    .minPrice(Integer.parseInt(store.getMinPrice()))
                    .minDeliveryTime(store.getDelivery().getMinDeliveryTime())
                    .deliveryTip(store.getDelivery().getDeliveryTip())
                    .detailCategoryName(store.getDetailCategory().getDetailCategoryName())
                    .build();
        }).collect(Collectors.toList());


        return ResponseCustom.OK(searchCategoryResList);
    }

    @Transactional
    public ResponseCustom<HomeRes> getAllCategories() {
        List<DetailCategory> detailCategoryList = detailCategoryRepository.findAll();
        List<DetailCategory> top5CategoryList = detailCategoryRepository.findByIdBetween(3L, 7L);


        List<CategoryRes> categoryResList = detailCategoryList.stream().map(category ->
                CategoryRes.builder()
                        .id(category.getId())
                        .categoryName(category.getDetailCategoryName())
                        .build()
        ).collect(Collectors.toList());

        List<CategoryRes> top5categoryList = top5CategoryList.stream().map(category ->
                CategoryRes.builder()
                        .id(category.getId())
                        .categoryName(category.getDetailCategoryName())
                        .categoryImgUrl(category.getCategoryImgUrl())
                        .build()
        ).collect(Collectors.toList());


        HomeRes homre = HomeRes.builder()
                .categoryResList(categoryResList)
                .top5CategoryResList(top5categoryList)
                .build();


        return ResponseCustom.OK(homre);
    }
}
