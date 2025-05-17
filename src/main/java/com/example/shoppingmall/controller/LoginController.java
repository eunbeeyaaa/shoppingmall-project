package com.example.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "users/login";
    }

    @GetMapping("/sign")
    public String sign() {
        return "users/sign";
    }

    @GetMapping("/findID")
    public String findId() { return "users/findID"; }

    @GetMapping("/findPW")
    public String findPW() { return "users/findPW"; }
}
