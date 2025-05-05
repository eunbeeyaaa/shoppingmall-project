package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 상의 카테고리 페이지
     * URL 예: GET /products/top
     */
    @GetMapping("/top")
    public String showTopCategory(Model model) {
        List<Product> tops = productService.getProductsByCategory("top");
        model.addAttribute("products", tops);
        model.addAttribute("categoryName", "TOP");
        return "products/top/top";
    }

}
