package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Menu;

import java.util.List;

public interface ProductService {
    List<Menu> getProductsByCategory(String category); // ✅ 수정됨
    Menu getProductDetail(String category, Long productId); // ✅ Product → Menu
    Menu getProductById(Long productId);
}
