package com.example.shoppingmall.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaRequest {
    private String content;
    private String memberName;
    private Boolean isLocked;
    private Long menuId;
}
