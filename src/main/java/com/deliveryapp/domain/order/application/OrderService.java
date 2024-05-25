package com.deliveryapp.domain.order.application;

import com.deliveryapp.domain.cart.domain.Cart;
import com.deliveryapp.domain.cart.domain.repository.CartRepository;
import com.deliveryapp.domain.order.domain.Order;
import com.deliveryapp.domain.order.domain.repository.OrderRepository;
import com.deliveryapp.domain.order.dto.OrderReq;
import com.deliveryapp.domain.order.dto.OrderRes;
import com.deliveryapp.domain.store.dto.StoreRes;
import com.deliveryapp.domain.user.domain.User;
import com.deliveryapp.domain.user.domain.repository.UserRepository;
import com.deliveryapp.global.payload.Message;
import com.deliveryapp.global.payload.ResponseCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Transactional
    public ResponseCustom<Message> order(OrderReq orderReq) {
        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));

        Order order = Order.builder()
                .totalPrice(orderReq.getTotalPrice())
                .requestMsg(orderReq.getRequestMsg())
                .orderStatus(orderReq.getOrderStatus())
                .build();

        // 장바구니 항목을 주문 항목으로 변환 및 저장
        List<Cart> cartItems = cartRepository.findAllById(orderReq.getCartIdList());
        for (Cart cartItem : cartItems) {
            cartItem.setOrder(order);
            cartRepository.save(cartItem);
        }

        orderRepository.save(order);


        return ResponseCustom.OK(Message.builder()
                .message("주문이 완료되었습니다.")
                .build());
    }
}
