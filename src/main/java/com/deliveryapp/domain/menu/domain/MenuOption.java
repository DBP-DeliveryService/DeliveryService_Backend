package com.deliveryapp.domain.menu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Menu_Option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "option_content")
    private String optionContent;

    @Builder
    public MenuOption(String optionName, String optionContent) {
        this.optionName = optionName;
        this.optionContent = optionContent;
    }
}
