package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Cart;

import java.util.List;

public interface CartService {
    void addItem(Long memberId, Long menuId, int quantity);
    void removeItem(Long cartId);
    List<Cart> getCartItemsByMember(Long memberId);
}
