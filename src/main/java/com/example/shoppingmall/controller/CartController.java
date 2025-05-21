package com.example.shoppingmall.controller;

import com.example.shoppingmall.request.CartRequest;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final MemberService memberService;

    @Autowired
    public CartController(CartService cartService, MemberService memberService) {
        this.cartService = cartService;
        this.memberService = memberService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartRequest request, HttpSession session) {
        String username = (String) session.getAttribute("username"); // 로그인 시 저장된 사용자명
        Long memberId = memberService.getIdByUsername(username);

        cartService.addItem(memberId, request.getMenuId(), request.getQuantity());
        return ResponseEntity.ok().body(Map.of("result", "success"));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
        cartService.removeItem(id);
        return ResponseEntity.ok().body(Map.of("result", "deleted"));
    }
}
