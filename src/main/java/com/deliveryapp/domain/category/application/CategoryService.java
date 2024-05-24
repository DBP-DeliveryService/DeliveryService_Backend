package com.deliveryapp.domain.category.application;

import com.deliveryapp.domain.category.domain.DetailCategory;
import com.deliveryapp.domain.category.domain.repository.DetailCategoryRepository;
import com.deliveryapp.domain.category.dto.CategoryRes;
import com.deliveryapp.domain.category.dto.SearchCategoryRes;
import com.deliveryapp.domain.store.domain.Delivery;
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

    public ResponseCustom<List<CategoryRes>> getAllCategories() {
        List<DetailCategory> detailCategoryList = detailCategoryRepository.findAll();

        List<CategoryRes> categoryResList = detailCategoryList.stream().map(category ->
                CategoryRes.builder()
                        .id(category.getId())
                        .categoryName(category.getDetailCategoryName())
                        .build()
        ).collect(Collectors.toList());
        return ResponseCustom.OK(categoryResList);
    }
}
