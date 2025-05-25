package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnaRepository extends JpaRepository<Qna, Long> {
    List<Qna> findByMenuId(Long menuId);
}