package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CartPageController {

    private final CartService cartService;

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart"; // templates/cart.html 렌더링
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCartItems(HttpSession session) {
        Object sessionMember = session.getAttribute("member");
        if (sessionMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "result", "fail",
                    "message", "로그인 상태가 아닙니다."
            ));
        }

        Member member = (Member) sessionMember;
        Long memberId = member.getId();

        // 메서드 이름을 getCartItemsByMember로 수정!
        List<Cart> cartItems = cartService.getCartItemsByMember(memberId);

        return ResponseEntity.ok(Map.of(
                "result", "success",
                "cartItems", cartItems
        ));
    }

}
