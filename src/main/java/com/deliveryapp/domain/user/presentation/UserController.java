package com.deliveryapp.domain.user.presentation;

import com.deliveryapp.domain.store.dto.StoreRes;
import com.deliveryapp.domain.user.application.UserService;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.domain.user.dto.UserRes;
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

@Tag(name = "MyPage", description = "MyPage API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/mypage")
public class UserController {

    private final UserService userService;

    @Operation(summary = "마이페이지 조회", description = "마이페이지를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마이페이지 조회 성공", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserRes.class)))}),
            @ApiResponse(responseCode = "400", description = "마이페이지 조회 실패", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/{userId}")
    public ResponseCustom<UserRes> getMyPage(
            @Parameter(description = "유저의 id를 입력해주세요.") @PathVariable Long userId
    ) {
        return userService.getMyPage(userId);
    }
}
