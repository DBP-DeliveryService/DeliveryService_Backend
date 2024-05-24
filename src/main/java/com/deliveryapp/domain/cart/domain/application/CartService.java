package com.deliveryapp.domain.cart.domain.application;

import com.deliveryapp.domain.cart.domain.Cart;
import com.deliveryapp.domain.cart.domain.dto.CartReq;
import com.deliveryapp.domain.cart.domain.repository.CartRepository;
import com.deliveryapp.domain.menu.domain.Menu;
import com.deliveryapp.domain.menu.domain.repository.MenuRepository;
import com.deliveryapp.domain.user.domain.User;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.global.payload.Message;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    public ResponseCustom<Message> addMenuInCart(Long menuId, CartReq cartReq) {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        Menu menu = menuRepository.findById(menuId).orElseThrow(RuntimeException::new);
        Cart cart = Cart.builder()
                .menu(menu)
                .quantity(cartReq.getQuantity())
                .user(user)
                .build();


        cartRepository.save(cart);

        return ResponseCustom.OK(Message.builder()
                .message("장바구니에 메뉴가 추가되었습니다.")
                .build());
    }
}
