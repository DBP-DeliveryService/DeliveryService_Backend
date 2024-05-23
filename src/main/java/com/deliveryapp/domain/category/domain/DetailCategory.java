package com.deliveryapp.domain.category.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "Detail_Catrogry")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetailCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "detail_category_name")
    private String detailCategoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public DetailCategory(String detailCategoryName, Category category) {
        this.detailCategoryName = detailCategoryName;
        this.category = category;
    }
}
