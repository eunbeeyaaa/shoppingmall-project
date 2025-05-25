package com.example.shoppingmall.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
}
