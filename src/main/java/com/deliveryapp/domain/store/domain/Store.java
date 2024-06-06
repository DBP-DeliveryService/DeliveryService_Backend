package com.deliveryapp.domain.store.domain;

import com.deliveryapp.domain.category.domain.DetailCategory;
import com.deliveryapp.domain.common.BaseEntity;
import com.deliveryapp.domain.menu.domain.Menu;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Store", indexes = {
        @Index(name = "idx_store_storeName", columnList = "storeName")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "storeAddress")
    private String storeAddress;

    @Column(name = "storePictureUrl")
    private String storePictureUrl;

    @Column(name = "storePhoneNum")
    private String storePhoneNum;

    @Column(name = "storeContent")
    private String storeContent;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "storeHour")
    private String storeHour;

    @Column(name = "operateStatus")
    private String operateStatus;

    @Column(name = "detailOperateStatus")
    private String detailOperateStatus;

    @Column(name = "minPrice")
    private String minPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_category_id")
    private DetailCategory detailCategory;

    @OneToOne(mappedBy = "store", fetch = FetchType.LAZY)
    private Delivery delivery;

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private List<Menu> menu = new ArrayList<>();



    @Builder
    public Store(String storeName, String storeAddress, String storePictureUrl, String storePhoneNum, String storeContent, Integer rating, String storeHour, String operateStatus, String detailOperateStatus, String minPrice) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePictureUrl = storePictureUrl;
        this.storePhoneNum = storePhoneNum;
        this.storeContent = storeContent;
        this.rating = rating;
        this.storeHour = storeHour;
        this.operateStatus = operateStatus;
        this.detailOperateStatus = detailOperateStatus;
        this.minPrice = minPrice;
    }
}
