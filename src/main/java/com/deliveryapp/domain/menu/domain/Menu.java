package com.deliveryapp.domain.menu.domain;

import com.deliveryapp.domain.store.domain.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_content")
    private String menuContent;

    @Column(name = "price")
    private Long price;

    @Column(name = "menu_picture_url")
    private String menuPictureUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;


    @Builder
    public Menu(String menuName, String menuContent, Long price, String menuPictureUrl, Store store) {
        this.menuName = menuName;
        this.menuContent = menuContent;
        this.price = price;
        this.menuPictureUrl = menuPictureUrl;
        this.store = store;
    }
}
