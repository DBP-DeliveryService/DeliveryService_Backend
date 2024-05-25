package com.deliveryapp.domain.user.application;

import com.deliveryapp.domain.user.domain.User;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.domain.user.dto.UserRes;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseCustom<UserRes> getMyPage(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(RuntimeException::new);

        UserRes userRes = UserRes.builder()
                .nickname(user.getNickname())
                .name(user.getUserName())
                .email(user.getUserEmail())
                .address(user.getUserAddress())
                .phoneNum(user.getUserPhoneNum())
                .build();

        return ResponseCustom.OK(userRes);
    }
}
