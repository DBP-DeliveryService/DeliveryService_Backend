package com.deliveryapp.domain.coupon.application;

import com.deliveryapp.domain.coupon.domain.Coupon;
import com.deliveryapp.domain.coupon.domain.CouponInfo;
import com.deliveryapp.domain.coupon.domain.repository.CouponInfoRepository;
import com.deliveryapp.domain.coupon.domain.repository.CouponRepository;
import com.deliveryapp.domain.coupon.dto.CouponReq;
import com.deliveryapp.domain.user.domain.User;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.global.payload.Message;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponInfoRepository couponInfoRepository;
    private final UserRepository userRepository;


    @Transactional
    public ResponseCustom<Message> generateCoupon(CouponReq couponReq) {

        CouponInfo couponInfo = couponInfoRepository.findByCouponCode(couponReq.getCouponCode());
        if (couponInfo == null) {
            return ResponseCustom.OK(Message.builder()
                            .message("유효하지 않은 쿠폰 코드입니다.")
                    .build());
        } else {
            Coupon coupon = Coupon.builder()
                    .couponInfo(couponInfo)
                    .couponStatus("Available")
                    .couponInfo(couponInfo)
                    .user(userRepository.findById(1L).orElseThrow(RuntimeException::new))
                    .build();
            couponRepository.save(coupon);
            return ResponseCustom.OK(Message.builder()
                            .message("쿠폰 발급에 성공했습니다."+ "쿠폰 아이디는: " + coupon.getId())
                    .build());
        }
    }
}
