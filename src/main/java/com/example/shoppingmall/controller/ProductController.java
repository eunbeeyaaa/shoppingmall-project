package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Menu;
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

    @GetMapping("/new")
    public String showNewCategory(Model model) {
        List<Menu> news = productService.getProductsByCategory("new");
        model.addAttribute("products", news);
        model.addAttribute("categoryName", "NEW");
        return "products/new/new";
    }

    @GetMapping("/best")
    public String showBestCategory(Model model) {
        List<Menu> bests = productService.getProductsByCategory("best");
        model.addAttribute("products", bests);
        model.addAttribute("categoryName", "BEST");
        return "products/best/best";
    }

    @GetMapping("/outer")
    public String showOuterCategory(Model model) {
        List<Menu> outers = productService.getProductsByCategory("outers");
        model.addAttribute("products", outers);
        model.addAttribute("categoryName", "OUTERS");
        return "products/outer/outer";
    }

    @GetMapping("/top")
    public String showTopCategory(Model model) {
        List<Menu> tops = productService.getProductsByCategory("top");
        model.addAttribute("products", tops);
        model.addAttribute("categoryName", "TOP");
        return "products/top/top";
    }

    @GetMapping("/bottom")
    public String showBottomCategory(Model model) {
        List<Menu> bottoms = productService.getProductsByCategory("bottom");
        model.addAttribute("products", bottoms);
        model.addAttribute("categoryName", "BOTTOM");
        return "products/bottom/bottom";
    }

    @GetMapping("/bag")
    public String showBagCategory(Model model) {
        List<Menu> bags = productService.getProductsByCategory("bag");
        model.addAttribute("products", bags);
        model.addAttribute("categoryName", "BAG");
        return "products/bag/bag";
    }

    @GetMapping("/shoes")
    public String showShoesCategory(Model model) {
        List<Menu> shoes = productService.getProductsByCategory("shoes");
        model.addAttribute("products", shoes);
        model.addAttribute("categoryName", "SHOES");
        return "products/shoes/shoes";
    }

    @GetMapping("/etc")
    public String showEtcCategory(Model model) {
        List<Menu> etcs = productService.getProductsByCategory("etc");
        model.addAttribute("products", etcs);
        model.addAttribute("categoryName", "ETC");
        return "products/etc/etc";
    }

    @GetMapping("/detail/{id}")
    public String showProductDetail(@PathVariable Long id, Model model) {
        Menu menu = productService.getProductById(id);
        model.addAttribute("product", menu);
        return "product"; // templates/product.html
    }
}
