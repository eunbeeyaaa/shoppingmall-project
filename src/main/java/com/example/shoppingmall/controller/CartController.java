package com.example.shoppingmall.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String CartController() {
        return "/users/cart";
    }

//    @GetMapping("/cart")
//    public String showCart(Model model, Principal principal) {
//        String userId = principal.getName(); // 로그인된 사용자 기준
//        List<CartItem> cartItems = cartService.getCartItemsByUser(userId);
//        model.addAttribute("cartItems", cartItems);
//        return "cart";
//    }
}
