package com.deliveryapp.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRes {
    private String nickname;
    private String name;
    private String email;
    private String phoneNum;
    private String address;

    @Builder
    public UserRes(String nickname, String name, String email, String phoneNum, String address) {
        this.nickname = nickname;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }
}
