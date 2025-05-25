package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Qna;
import com.example.shoppingmall.request.QnaRequest;

import java.util.List;

public interface QnaService {
    List<Qna> getQnasByMenu(Long menuId);
    void saveQna(QnaRequest request);
}
