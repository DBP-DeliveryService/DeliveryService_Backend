package com.deliveryapp.domain.cart.domain.presentation;

import com.deliveryapp.domain.cart.domain.application.CartService;
import com.deliveryapp.domain.cart.domain.dto.CartListRes;
import com.deliveryapp.domain.cart.domain.dto.CartReq;
import com.deliveryapp.domain.category.dto.SearchCategoryRes;
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

import java.util.List;

@Tag(name = "Cart", description = "Cart API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;


    @Operation(summary = "장바구니 담기", description = "장바구니에 음식을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "장바구니 추가 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Message.class)))}),
            @ApiResponse(responseCode = "400", description = "장바구니 추가 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @PostMapping("/{menuId}")
    public ResponseCustom<Message> addMenuInCart(
            @Parameter(description = "메뉴의 id를 입력해주세요.") @PathVariable Long menuId,
            @Parameter(description = "수량을 입력해주세요.") @RequestBody CartReq cartReq
    ) {
        return cartService.addMenuInCart(menuId, cartReq);
    }

    @Operation(summary = "장바구니 조회", description = "장바구니에 담긴 메뉴를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "장바구니 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CartListRes.class)))}),
            @ApiResponse(responseCode = "400", description = "장바구니 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping()
    public ResponseCustom<List<CartListRes>> addMenuInCart(
    ) {
        return cartService.findCartList();
    }
}
