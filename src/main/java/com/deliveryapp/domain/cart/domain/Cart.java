package com.deliveryapp.domain.cart.domain;

import com.deliveryapp.domain.common.BaseEntity;
import com.deliveryapp.domain.menu.domain.Menu;
import com.deliveryapp.domain.order.domain.Order;
import com.deliveryapp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Table(name = "Cart")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    @ColumnDefault("1")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


    @Builder
    public Cart(Integer quantity, User user, Menu menu) {
        this.quantity = quantity;
        this.user = user;
        this.menu = menu;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
