package com.deliveryapp.domain.coupon.application;

import com.deliveryapp.domain.coupon.domain.Coupon;
import com.deliveryapp.domain.coupon.domain.CouponInfo;
import com.deliveryapp.domain.coupon.domain.repository.CouponInfoRepository;
import com.deliveryapp.domain.coupon.domain.repository.CouponRepository;
import com.deliveryapp.domain.coupon.dto.CouponListRes;
import com.deliveryapp.domain.coupon.dto.CouponReq;
import com.deliveryapp.domain.coupon.dto.CouponRes;
import com.deliveryapp.domain.user.domain.User;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.global.payload.Message;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public ResponseCustom<CouponListRes> findCouponList() {
        List<Coupon> coupons = couponRepository.findByUserId(1L);
        List<CouponRes> couponResList = coupons.stream().map(coupon ->
                CouponRes.builder()
                        .id(coupon.getId())
                        .couponStatus(coupon.getCouponStatus())
                        .couponName(coupon.getCouponInfo().getCouponName())
                        .discountAmount(coupon.getCouponInfo().getDiscountAmount())
                        .couponContent(coupon.getCouponInfo().getCouponContent())
                        .minPrice(coupon.getCouponInfo().getMinPrice())
                        .expiredDate(coupon.getCouponInfo().getExpiredDate())
                        .build()
        ).collect(Collectors.toList());

        CouponListRes couponListRes = CouponListRes.builder()
                .couponResList(couponResList)
                .build();

        return ResponseCustom.OK(couponListRes);
    }
}
