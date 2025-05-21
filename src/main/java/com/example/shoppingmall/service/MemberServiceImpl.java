package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Member;
import com.example.shoppingmall.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long getIdByUsername(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자 정보를 찾을 수 없습니다: " + username));
        return member.getId();
    }
}
