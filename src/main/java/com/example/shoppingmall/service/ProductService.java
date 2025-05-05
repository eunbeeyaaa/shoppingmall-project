package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

public interface ProductService {
    List<Product> getProductsByCategory(String category);
    Product getProductDetail(String category, Long productId);
}
