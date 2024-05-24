package com.deliveryapp.domain.category.presentation;

import com.deliveryapp.domain.category.application.CategoryService;
import com.deliveryapp.domain.category.dto.CategoryRes;
import com.deliveryapp.domain.category.dto.SearchCategoryRes;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Category", description = "Category API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService; //


    @Operation(summary = "카테고리별 음식점 리스트 조회", description = "음식점 리스트를 카테고리에 따라 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "음식점 리스트 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SearchCategoryRes.class)))}),
            @ApiResponse(responseCode = "400", description = "음식점 리스트 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/{categoryId}")
    public ResponseCustom<List<SearchCategoryRes>> searchByCategory(
            @Parameter(description = "카테고리의 id를 입력해주세요.") @PathVariable Long categoryId
    ) {
        return categoryService.searchStoresByCategory(categoryId);
    }

    @Operation(summary = "카테고리 조회", description = "전체 카테고리를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "전체 카테고리 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoryRes.class)))}),
            @ApiResponse(responseCode = "400", description = "전체 카테고리 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping()
    public ResponseCustom<List<CategoryRes>> getAllCategories(
    ) {
        return categoryService.getAllCategories();
    }


}
