package com.example.shoppingmall.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPageController {

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

        // 장바구니 아이템 목록을 불러와 반환
        List<Cart> cartItems = cartService.getCartItemsByMemberId(memberId);

        return ResponseEntity.ok(Map.of(
                "result", "success",
                "cartItems", cartItems
        ));
    }

}
