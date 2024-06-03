package com.deliveryapp.domain.coupon.presentation;


import com.deliveryapp.domain.coupon.application.CouponService;
import com.deliveryapp.domain.coupon.dto.CouponListRes;
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
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "보유 쿠폰 조회하기", description = "보유하고 있는 쿠폰들을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "쿠폰 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CouponListRes.class)))}),
            @ApiResponse(responseCode = "400", description = "쿠폰 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("")
    public ResponseCustom<CouponListRes> findCouponList() {
        return couponService.findCouponList();
    }
}
