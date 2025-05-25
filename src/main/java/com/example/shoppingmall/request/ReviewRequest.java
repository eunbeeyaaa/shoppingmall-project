package com.example.shoppingmall.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private String content;
    private String memberName;
    private String gender;
    private String size;
    private Integer height;
    private Integer weight;
    private Long menuId;
}