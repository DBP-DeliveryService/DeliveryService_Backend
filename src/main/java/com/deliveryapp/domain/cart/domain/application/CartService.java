package com.deliveryapp.domain.cart.domain.application;

import com.deliveryapp.domain.cart.domain.Cart;
import com.deliveryapp.domain.cart.domain.dto.CartListRes;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;

    @Transactional
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

    @Transactional
    public ResponseCustom<List<CartListRes>> findCartList() {

        List<Cart> cartList = cartRepository.findAll();

        List<CartListRes> cartListRes = cartList.stream()
                .map(cart -> new CartListRes(
                        cart.getId(),
                        cart.getMenu().getMenuName(),
                        cart.getQuantity(),
                        cart.getMenu().getMenuContent(),
                        cart.getMenu().getPrice()
                ))
                .collect(Collectors.toList());


        return ResponseCustom.OK(cartListRes);
    }

    @Transactional
    public ResponseCustom<Message> deleteCartOne(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(RuntimeException::new);

        cartRepository.delete(cart);


        return ResponseCustom.OK(Message.builder().message("장바구니에서 삭제되었습니다.").build());
    }

    @Transactional
    public ResponseCustom<Message> modifyCartOne(Long cartId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(RuntimeException::new);

        cart.updateCart(cart.getId(), quantity);


        return ResponseCustom.OK(Message.builder().message("수량이 수정되었습니다.").build());
    }
}
