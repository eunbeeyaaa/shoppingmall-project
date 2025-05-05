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

    @GetMapping("/selectMenuDetail")
    public String getMenuDetail(Model model) {
        List<Menu> menuDetailList = menuRepository.findAll();
        model.addAttribute("menus", menuDetailList);
        return "menus";  // templates/menu.html
    }
}
