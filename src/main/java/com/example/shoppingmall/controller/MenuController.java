package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuRepository menuRepository;

    @GetMapping("/menus")
    public String getMenuPage(Model model) {
        List<Menu> menus = menuRepository.findAll();
        model.addAttribute("menus", menus);
        return "menus";  // templates/menus.html
    }
}
