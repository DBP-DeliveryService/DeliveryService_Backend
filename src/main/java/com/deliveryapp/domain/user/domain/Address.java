package com.deliveryapp.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "Address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "is_selected")
    @ColumnDefault("false")
    private Boolean isSelected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Address(String userAddress, Boolean isSelected, User user) {
        this.userAddress = userAddress;
        this.isSelected = isSelected;
        this.user = user;
    }
}
