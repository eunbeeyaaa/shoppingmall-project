package com.example.shoppingmall.service;

import com.example.shoppingmall.request.MemberRequest;

public interface MemberService {
    Long getIdByUsername(String username);
    void registerMember(MemberRequest requestDto);
}
