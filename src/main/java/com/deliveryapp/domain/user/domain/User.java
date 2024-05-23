package com.deliveryapp.domain.user.domain;

import com.deliveryapp.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email", nullable = false, unique = true, updatable = false)
    private String userEmail;

    @Column(name = "name")
    private String userName;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_phone_num")
    private String userPhoneNum;


    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;


    @Builder
    public User(String nickname, String userEmail, String userName, String userAddress, String userPhoneNum, Role role) {
        this.nickname = nickname;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhoneNum = userPhoneNum;
        this.role = role;
    }
}
