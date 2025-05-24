package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.MemberService;
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

    private final MemberService memberService;
    private final CartService cartService;

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart"; // templates/cart.html 렌더링
    }

    @GetMapping("/list")
    public ResponseEntity<?> getCartItems(HttpSession session) {
        Object sessionMember = session.getAttribute("username");
        if (sessionMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "result", "fail",
                    "message", "로그인 상태가 아닙니다."
            ));
        }

        String username = (String) session.getAttribute("username"); // 로그인 시 저장된 사용자명

        Long memberId = memberService.getIdByUsername(username);

        // 메서드 이름을 getCartItemsByMember로 수정!
        List<Cart> cartItems = cartService.getCartItemsByMember(memberId);

        return ResponseEntity.ok(Map.of(
                "result", "success",
                "cartItems", cartItems
        ));
    }

}

