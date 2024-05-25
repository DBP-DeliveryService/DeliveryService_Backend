package com.deliveryapp.domain.order.presentation;

import com.deliveryapp.domain.order.application.OrderService;
import com.deliveryapp.domain.order.dto.OrderReq;
import com.deliveryapp.domain.order.dto.OrderRes;
import com.deliveryapp.domain.store.dto.StoreRes;
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

@Tag(name = "Order", description = "Order API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "주문하기", description = "음식을 최종적으로 주문합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "음식 주문 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Message.class)))}),
            @ApiResponse(responseCode = "400", description = "음식 주문 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @PostMapping("")
    public ResponseCustom<Message> order(
            @Parameter(description = "OrderReq를 참고해주세요.") @RequestBody OrderReq orderReq
    ) {
        return orderService.order(orderReq);
    }
}
