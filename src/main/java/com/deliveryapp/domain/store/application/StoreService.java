package com.deliveryapp.domain.store.application;

import com.deliveryapp.domain.category.dto.SearchCategoryRes;
import com.deliveryapp.domain.menu.domain.Menu;
import com.deliveryapp.domain.menu.domain.repository.MenuRepository;
import com.deliveryapp.domain.store.domain.Store;
import com.deliveryapp.domain.store.domain.repository.StoreRepository;
import com.deliveryapp.domain.store.dto.MenuRes;
import com.deliveryapp.domain.store.dto.StoreRes;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public ResponseCustom<StoreRes> searchStoresByCategory(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(RuntimeException::new);

        List<MenuRes> menuResList = store.getMenu().stream().map(menu ->
                MenuRes.builder()
                        .menuName(menu.getMenuName())
                        .menuContent(menu.getMenuContent())
                        .price(menu.getPrice())
                        .menuPictureUrl(menu.getMenuPictureUrl())
                        .build()
        ).collect(Collectors.toList());


        StoreRes storeRes = StoreRes.builder()
                .storeName(store.getStoreName())
                .deliveryTip(store.getDelivery().getDeliveryTip())
                .rating(store.getRating())
                .menuList(menuResList)
                .minPrice(store.getMinPrice())
                .build();

        return ResponseCustom.OK(storeRes);
    }

    @Transactional
    public ResponseCustom<MenuRes> searchOneMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(RuntimeException::new);

        MenuRes menuRes = MenuRes.builder()
                .menuName(menu.getMenuName())
                .menuContent(menu.getMenuContent())
                .menuPictureUrl(menu.getMenuPictureUrl())
                .price(menu.getPrice())
                .build();

        return ResponseCustom.OK(menuRes);
    }

    public ResponseCustom<SearchCategoryRes> searchStoresByStoreName(String storeName) {
        Store store = storeRepository.findByStoreName(storeName).orElseThrow(NullPointerException::new);

        SearchCategoryRes searchCategoryRes = SearchCategoryRes
                .builder()
                .storeName(store.getStoreName())
                .detailOpreateStatus(store.getDetailOperateStatus())
                .rating(store.getRating())
                .minPrice(Integer.parseInt(store.getMinPrice()))
                .minDeliveryTime(store.getDelivery().getMinDeliveryTime())
                .deliveryTip(store.getDelivery().getDeliveryTip())
                .detailCategoryName(store.getDetailCategory().getDetailCategoryName())
                .build();
        return ResponseCustom.OK(searchCategoryRes);
    }
}
