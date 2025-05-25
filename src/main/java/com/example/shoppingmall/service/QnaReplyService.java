package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.QnaReply;
import com.example.shoppingmall.request.QnaReplyRequest;

import java.util.List;

public interface QnaReplyService {
    List<QnaReply> getRepliesByQna(Long qnaId);
    void saveReply(QnaReplyRequest request);
}