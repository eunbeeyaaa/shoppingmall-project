package com.example.shoppingmall.controller;

import com.example.shoppingmall.request.MemberRequest;
import com.example.shoppingmall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/sign")
    public String registerMember(@ModelAttribute MemberRequest requestDto, RedirectAttributes redirectAttributes) {
        memberService.registerMember(requestDto);
        redirectAttributes.addFlashAttribute("successMessage", "회원가입이 완료되었습니다!");
        return "redirect:/login";
    }

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
