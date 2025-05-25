package com.example.shoppingmall.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaReplyRequest {
    private String content;
    private Long qnaId;
}