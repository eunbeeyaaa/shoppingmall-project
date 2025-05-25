package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Cart;

import java.util.List;

public interface CartService {
    void addItem(Long memberId, Long menuId, int quantity, String color, String size);
    void removeItem(Long memberId, Long cartId);
    List<Cart> getCartItemsByMember(Long memberId);
}
