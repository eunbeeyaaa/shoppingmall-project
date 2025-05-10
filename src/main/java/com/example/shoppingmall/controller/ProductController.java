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
     * 신상 카테고리 페이지
     * URL 예: GET /products/new
     */
    @GetMapping("/new")
    public String showNewCategory(Model model) {
        List<Product> news = productService.getProductsByCategory("new");
        model.addAttribute("products", news);
        model.addAttribute("categoryName", "NEW");
        return "products/new/new";
    }

    /**
     * Best 카테고리 페이지
     * URL 예: GET /products/best
     */
    @GetMapping("/best")
    public String showBestCategory(Model model) {
        List<Product> bests = productService.getProductsByCategory("best");
        model.addAttribute("products", bests);
        model.addAttribute("categoryName", "BEST");
        return "products/best/best";
    }

    /**
     * 겉옷 카테고리 페이지
     * URL 예: GET /products/outer
     */
    @GetMapping("/outer")
    public String showOuterCategory(Model model) {
        List<Product> outers = productService.getProductsByCategory("outers");
        model.addAttribute("products", outers);
        model.addAttribute("categoryName", "OUTERS");
        return "products/outer/outer";
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

    /**
     * 하의 카테고리 페이지
     * URL 예: GET /products/bottom
     */
    @GetMapping("/bottom")
    public String showBottomCategory(Model model) {
        List<Product> bottoms = productService.getProductsByCategory("bottom");
        model.addAttribute("products", bottoms);
        model.addAttribute("categoryName", "BOTTOM");
        return "products/bottom/bottom";
    }

    /**
     * 가방 카테고리 페이지
     * URL 예: GET /products/bag
     */
    @GetMapping("/bag")
    public String showBagCategory(Model model) {
        List<Product> bags = productService.getProductsByCategory("bag");
        model.addAttribute("products", bags);
        model.addAttribute("categoryName", "BAG");
        return "products/bag/bag";
    }

    /**
     * 신발 카테고리 페이지
     * URL 예: GET /products/shoes
     */
    @GetMapping("/shoes")
    public String showShoesCategory(Model model) {
        List<Product> shoes = productService.getProductsByCategory("shoes");
        model.addAttribute("products", shoes);
        model.addAttribute("categoryName", "SHOES");
        return "products/shoes/shoes";
    }

    /**
     * 기타 카테고리 페이지
     * URL 예: GET /products/etc
     */
    @GetMapping("/etc")
    public String showEtcCategory(Model model) {
        List<Product> etcs = productService.getProductsByCategory("etc");
        model.addAttribute("products", etcs);
        model.addAttribute("categoryName", "ETC");
        return "products/etc/etc";
    }

}
