package com.deliveryapp.domain.coupon.presentation;


import com.deliveryapp.domain.coupon.application.CouponService;
import com.deliveryapp.domain.coupon.dto.CouponReq;
import com.deliveryapp.domain.order.dto.OrderReq;
import com.deliveryapp.global.payload.ErrorResponse;
import com.deliveryapp.global.payload.Message;
import com.deliveryapp.global.payload.ResponseCustom;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Coupon", description = "Coupon API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    @Operation(summary = "쿠폰 발급하기", description = "쿠폰을 발급합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "쿠폰 발급 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Message.class)))}),
            @ApiResponse(responseCode = "400", description = "쿠폰 발급 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @PostMapping("")
    public ResponseCustom<Message> generateCoupon(
            @Parameter(description = "CouponReq를 참고해주세요.") @RequestBody CouponReq couponReq
    ) {
        return couponService.generateCoupon(couponReq);
    }
}
