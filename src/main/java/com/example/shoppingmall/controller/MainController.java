package com.example.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // MainController 클래스에 @Controller 어노테이션을 추가
public class MainController {

    @GetMapping("/")
    public String home() {
        return "main";  // templates/main.html을 반환
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

}
