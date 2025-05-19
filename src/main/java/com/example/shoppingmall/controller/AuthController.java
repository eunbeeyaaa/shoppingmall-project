package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final MemberRepository memberRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of(
                    "result", "fail",
                    "message", "아이디 또는 비밀번호가 누락되었습니다."
            ));
        }

        Optional<Member> optionalMember = memberRepository.findByUsername(username);

        if (optionalMember.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "result", "fail",
                    "message", "존재하지 않는 사용자입니다."
            ));
        }

        Member member = optionalMember.get();

        if (!member.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "result", "fail",
                    "message", "비밀번호가 올바르지 않습니다."
            ));
        }

        // 로그인 성공 - 세션 저장
        session.setAttribute("member", member);

        return ResponseEntity.ok(Map.of(
                "result", "success",
                "message", "로그인 성공"
        ));
    }
}
