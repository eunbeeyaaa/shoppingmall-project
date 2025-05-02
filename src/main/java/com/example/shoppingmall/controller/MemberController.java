package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/selectMemberDetail")
    public String getMemberDetail(Model model) {
        List<Member> memberDetailList = memberRepository.findAll();
        model.addAttribute("mypage", memberDetailList);
        return "mypage";  // templates/mypage.html
    }
}
