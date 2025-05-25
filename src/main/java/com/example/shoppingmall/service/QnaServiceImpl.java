package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.entity.Qna;
import com.example.shoppingmall.repository.MenuRepository;
import com.example.shoppingmall.repository.QnaRepository;
import com.example.shoppingmall.request.QnaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QnaServiceImpl implements QnaService {

    private final QnaRepository qnaRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public QnaServiceImpl(QnaRepository qnaRepository, MenuRepository menuRepository) {
        this.qnaRepository = qnaRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Qna> getQnasByMenu(Long menuId) {
        return qnaRepository.findByMenuId(menuId);
    }

    @Override
    public void saveQna(QnaRequest request) {
        Menu menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(() -> new NoSuchElementException("메뉴 없음!"));

        Qna qna = new Qna();
        qna.setContent(request.getContent());
        qna.setMemberName(request.getMemberName());
        qna.setIsLocked(request.getIsLocked());
        qna.setMenu(menu);
        qna.setCreatedAt(LocalDateTime.now());

        qnaRepository.save(qna);
    }
}
