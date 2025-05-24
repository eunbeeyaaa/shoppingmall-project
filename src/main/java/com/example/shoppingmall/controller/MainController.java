package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.repository.MenuRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller  // MainController 클래스에 @Controller 어노테이션을 추가
public class MainController {

    private final MenuRepository menuRepository;

    public MainController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Menu> menus = menuRepository.findAll();
        model.addAttribute("menus", menus);
        return "main";
    }
    //@GetMapping("/")
    //public String home() {
    //    return "main";  // templates/main.html을 반환
    //}

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/searchResult")
    public String searchResult() {
        return "searchResult";
    }

    @GetMapping("/product")
    public String productPage() { return "product"; }
}
