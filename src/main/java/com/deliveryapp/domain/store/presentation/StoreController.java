package com.deliveryapp.domain.store.presentation;

import com.deliveryapp.domain.category.dto.SearchCategoryRes;
import com.deliveryapp.domain.store.application.StoreService;
import com.deliveryapp.domain.store.dto.MenuRes;
import com.deliveryapp.domain.store.dto.StoreRes;
import com.deliveryapp.global.payload.ErrorResponse;
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

@Tag(name = "Store", description = "Store API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @Operation(summary = "가게명 검색", description = "가게명으로 가게 정보를 검색합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 정보 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SearchCategoryRes.class)))}),
            @ApiResponse(responseCode = "400", description = "가게 정보 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/search")
    public ResponseCustom<SearchCategoryRes> searchByStoreName(
            @Parameter(description = "가게의 storeName을 입력해주세요.") @RequestParam String storeName
    ) {
        return storeService.searchStoresByStoreName(storeName);
    }

    @Operation(summary = "가게 상세 조회", description = "가게 정보를 상세 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "가게 정보 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreRes.class)))}),
            @ApiResponse(responseCode = "400", description = "가게 정보 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/{storeId}")
    public ResponseCustom<StoreRes> searchByStoreId(
            @Parameter(description = "가게의 id를 입력해주세요.") @PathVariable Long storeId
    ) {
        return storeService.searchStoresByCategory(storeId);
    }

    @Operation(summary = "메뉴 상세 조회", description = "메뉴 정보를 상세 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 정보 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MenuRes.class)))}),
            @ApiResponse(responseCode = "400", description = "메뉴 정보 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/menu/{menuId}")
    public ResponseCustom<MenuRes> searchOneMenu(
            @Parameter(description = "메뉴의 id를 입력해주세요.") @PathVariable Long menuId
    ) {
        return storeService.searchOneMenu(menuId);
    }


}
